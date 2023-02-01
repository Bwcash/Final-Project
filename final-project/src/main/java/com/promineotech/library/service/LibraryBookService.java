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

List<Books> updateBookStatus(String book_status, String book_title);





}
