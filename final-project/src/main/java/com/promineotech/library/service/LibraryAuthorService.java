/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;

import com.promineotech.library.entity.Author_Books;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryAuthorService {


	List<Author_Books> fetchBooksByAuthor(String author_name);

}
