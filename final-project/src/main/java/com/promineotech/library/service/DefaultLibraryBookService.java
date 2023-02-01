/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
		return  bookDao.fetchAllBooks();
		
	}

	@Override
	public List<Books> updateBookStatus(String book_status, String book_title) {
		if((book_title == null) || (book_status == null)) {
			throw new NoSuchElementException(String.format("You must enter a book title and a book status", book_title)) ;
		}
		else if(book_status.length() >=  4){
			throw new ConstraintViolationException("Book status can only be 'In' or 'Out'.", null);
		}
		else {
		return bookDao.updateBookStatus(book_status, book_title);
		}
	}
}
