/**
 * 
 */
package com.promineotech.library.dao;

import java.util.List;

import com.promineotech.library.entity.Book_Genre;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryBookGenreDao {

	List<Book_Genre> fetchBooksByGenre(String genre_name);

}
