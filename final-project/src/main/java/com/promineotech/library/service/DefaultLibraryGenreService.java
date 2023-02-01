/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.library.dao.LibraryGenreDao;
import com.promineotech.library.entity.Genre;

/**
 * @author Bryce Cash
 *
 */
@Service
public class DefaultLibraryGenreService implements LibraryGenreService {
private LibraryGenreDao genreDao;
public DefaultLibraryGenreService(LibraryGenreDao genreDao) {
	this.genreDao =genreDao;
}
	@Override
	public List<Genre> fetchAllGenres() {
		return genreDao.fetchAllGenres();
	}

}
