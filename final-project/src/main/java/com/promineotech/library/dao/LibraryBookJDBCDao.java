/**
 * 
 */
package com.promineotech.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
	public List<Books> fetchBooksByAuthor(String author_name) {
//		@formatter:off
		String sql = "SELECT a.author_name , b.* "
				+ "FROM author a "
				+ "INNER JOIN books b "
				+ "ON a.author_id = b.author_id "
				+ "WHERE author_name = :author_name";
//		@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("author_name", author_name);
		
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
	

}
