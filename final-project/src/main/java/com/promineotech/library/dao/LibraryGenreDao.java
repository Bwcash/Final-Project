/**
 * 
 */
package com.promineotech.library.dao;

import java.util.List;

import com.promineotech.library.entity.Genre;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryGenreDao {

	List<Genre> fetchAllGenres();

}
