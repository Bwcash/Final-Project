/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.promineotech.library.dao.LibraryAuthorDao;
import com.promineotech.library.entity.Author_Books;

/**
 * @author Bryce Cash
 *
 */
@Service
public class DefaultAuthorService implements LibraryAuthorService{
private LibraryAuthorDao authorDao;

public DefaultAuthorService(LibraryAuthorDao authorDao) {
	this.authorDao = authorDao;
}

	@Override
	public List<Author_Books> fetchBooksByAuthor(String author_name) {
		
		if(author_name != null) {
			List<Author_Books> author_Books = authorDao.fetchBooksByAuthor(author_name);
		if(author_Books.isEmpty()) {
			String mgs = String.format("No books found with the author_name=%s", author_name);
			throw new NoSuchElementException(mgs);
		}
		return author_Books ;
		}
		String mgs1 = String.format("author_name=%s cannot be blank", author_name);
		throw new NoSuchElementException(mgs1);
	}

}
