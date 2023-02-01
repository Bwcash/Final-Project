/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.library.entity.Books;
import com.promineotech.library.service.LibraryBookService;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Bryce Cash
 *
 */
@Tag(name = "Books Controller")
@RestController
public class BooksController implements IBookController{
	private LibraryBookService bookservice;
	
	public BooksController(LibraryBookService bookservice) {
		this.bookservice = bookservice;
	}
	@Override
	public List<Books> fetchAllBooks(){
		return  bookservice.fetchAllBooks();
		
		
	}
	@Override
	public List<Books> updateBookStatus(String book_status, String book_title) {
		return bookservice.updateBookStatus(book_status, book_title);
		 
	}
	
}
