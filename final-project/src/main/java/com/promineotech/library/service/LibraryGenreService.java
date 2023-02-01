/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;

import com.promineotech.library.entity.Genre;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryGenreService {

	List<Genre> fetchAllGenres();

}
