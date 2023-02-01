/**
 * 
 */
package com.promineotech.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.promineotech.library.entity.Author_Books;
import com.promineotech.library.entity.Books;



/**
 * @author Bryce Cash
 *
 */

@Repository
public class LibraryBookJDBCDao implements LibraryBookDao {
private NamedParameterJdbcTemplate provider;
	public LibraryBookJDBCDao(NamedParameterJdbcTemplate provider) {
		this.provider =provider;
	}
	@Override
	public List<Books> fetchAllBooks() {
		String sql ="SELECT * "
				+ "FROM books ";
		Map<String, Object> params = new HashMap<>();
		
		return provider.query(sql, params, new RowMapper<>() {

			@Override
			public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
//				@formatter:off
				return Books.builder()
						.author_id(rs.getInt("author_id"))
						.book_isbn(rs.getString("book_isbn"))
						.book_status(rs.getString("book_status"))
						.book_title(rs.getString("book_title"))
						.build();
//				@formatter:on
			}
		});
	}
	
	@Override
	public List<Books> updateBookStatus(String book_status, String book_title) {
//		@formatter:off
		String sql= "UPDATE books "
				+ "SET book_status = :book_status "
				+ "WHERE book_title = :book_title;";
//		@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("book_status", book_status);
		params.put("book_title", book_title);
		
		int rows = provider.update(sql, params);
		if(rows !=1) {
			String msg = String.format("Book Status '%s' on Book Title '%s' was not updated", book_status, book_title);
		throw new ConstraintViolationException(msg, null);
		}
		return fetchAllBooks();
	}
	

}
