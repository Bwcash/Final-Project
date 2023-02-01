/**
 * 
 */
package com.promineotech.library.dao;

import java.util.List;


import com.promineotech.library.entity.Books;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryBookDao {
/**
 * Retrieves all books in the library.
 * @return all books
 */
	List<Books> fetchAllBooks();

List<Books> updateBookStatus(String book_status, String book_title);

}
