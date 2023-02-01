/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;

import com.promineotech.library.entity.Book_Genre;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryBookGenreService {

	List<Book_Genre> fetchBooksByGenre(String genre_name);

}
