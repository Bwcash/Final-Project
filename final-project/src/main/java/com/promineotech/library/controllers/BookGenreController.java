/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.library.entity.Book_Genre;
import com.promineotech.library.service.LibraryBookGenreService;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Bryce Cash
 *
 */
@Tag(name = "Book_Genre Controller")
@RestController
public class BookGenreController implements IBookGenreController {
private LibraryBookGenreService bookGenreService;
public BookGenreController(LibraryBookGenreService bookGenreService) {
	this.bookGenreService =bookGenreService;
}
	@Override
	public List<Book_Genre> fetchBooksByGenre(String genre_name) {
		return bookGenreService.fetchBooksByGenre(genre_name);
	}

}
