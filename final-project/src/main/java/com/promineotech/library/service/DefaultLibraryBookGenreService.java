/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.promineotech.library.dao.LibraryBookGenreDao;
import com.promineotech.library.entity.Book_Genre;

/**
 * @author Bryce Cash
 *
 */
@Service
public class DefaultLibraryBookGenreService implements LibraryBookGenreService {
private LibraryBookGenreDao bookGenreDao;
public DefaultLibraryBookGenreService(LibraryBookGenreDao bookGenreDao) {
	this.bookGenreDao =bookGenreDao;
}
	@Override
	public List<Book_Genre> fetchBooksByGenre(String genre_name) {
		
		if(genre_name != null) {
		List<Book_Genre> genre = bookGenreDao.fetchBooksByGenre(genre_name);
		if(genre.isEmpty()) {
			String mgs1 = String.format("There are no books with that genre_name=%s", genre_name);
			throw new NoSuchElementException(mgs1);
		}
		return genre;
		}	
		String mgs = String.format("genre_name=%s cannot be blank", genre_name);
			throw new NoSuchElementException(mgs);
		
	}

}
