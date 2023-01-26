/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.library.dao.LibraryBookDao;
import com.promineotech.library.entity.Books;

/**
 * @author Bryce Cash
 *
 */
@Service
public class DefaultLibraryBookService implements LibraryBookService {
private LibraryBookDao bookDao;

public DefaultLibraryBookService(LibraryBookDao bookDao) {
	this.bookDao = bookDao;
}
	
	@Override
	public List<Books> fetchAllBooks() {
		List<Books> books =bookDao.fetchAllBooks();
		return books;
	}

	@Override
	public List<Books> fetchBooksByAuthor(String author_name) {
		List<Books> books = bookDao.fetchBooksByAuthor(author_name);
		return books;
	}

}
