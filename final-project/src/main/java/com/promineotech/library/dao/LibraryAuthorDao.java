/**
 * 
 */
package com.promineotech.library.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.promineotech.library.entity.Author_Books;

/**
 * @author Bryce Cash
 *
 */

public interface LibraryAuthorDao {

	List<Author_Books> fetchBooksByAuthor(String author_name);

}
