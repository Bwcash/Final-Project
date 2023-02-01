/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.library.entity.Author_Books;
import com.promineotech.library.service.LibraryAuthorService;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Bryce Cash
 *
 */
@Tag(name ="Author Controller")
@RestController
public class AuthorController implements IAuthorController {
private LibraryAuthorService authorService;

public AuthorController(LibraryAuthorService authorService) {
	 this.authorService = authorService;
}
	
	@Override
	public List<Author_Books> fetchBooksByAuthor(String author_name) {
		
		return authorService.fetchBooksByAuthor(author_name);
	}

}
