/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.library.entity.Books;
import com.promineotech.library.service.LibraryBookService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Bryce Cash
 *
 */
@Tag(name = "Books Controller")
@OpenAPIDefinition(info = @Info(title = "Mrs. Cash's library"))
@RestController
public class BooksController {
	private LibraryBookService bookservice;
	
	public BooksController(LibraryBookService bookservice) {
		this.bookservice = bookservice;
	}

	@Operation(summary = "Get a list of all books in library")
	@GetMapping(value = "/books")
	public List<Books> fetchAllBooks(){
		List<Books> books = bookservice.fetchAllBooks();
		return books;
		
	}
	
	@Operation(summary = "Get a list of books by author name")
	@GetMapping(value = "/author/{author_name}/books")
	public List<Books> fetchBooksByAuthor(String author_name){
		List<Books> books =bookservice.fetchBooksByAuthor(author_name);
		return books;
	}
	
}
