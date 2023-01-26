/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;

import com.promineotech.library.entity.Books;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryBookService {
/**
 * gets all books in library.
 * @return
 */
	List<Books> fetchAllBooks();

List<Books> fetchBooksByAuthor(String author_name);

}
