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

import com.promineotech.library.entity.Author_Books;


/**
 * @author Bryce Cash
 *
 */
@Repository
public class LibraryAuthorJDBCDao implements LibraryAuthorDao {
	private NamedParameterJdbcTemplate provider;
	public LibraryAuthorJDBCDao(NamedParameterJdbcTemplate provider) {
		this.provider =provider;
	}
	@Override
	public List<Author_Books> fetchBooksByAuthor(String author_name) {
		
		//		@formatter:off
		String sql = "SELECT a.author_name , b.book_title "
				+ "FROM author a "
				+ "INNER JOIN books b "
				+ "ON a.author_id = b.author_id "
				+ "WHERE author_name = :author_name";
//		@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("author_name", author_name);
		
		return provider.query(sql, params, new RowMapper<>() {

			@Override
			public Author_Books mapRow(ResultSet rs, int rowNum) throws SQLException {
//				@formatter:off
				return Author_Books.builder()
						.author_name(rs.getString("author_name"))
						.book_title(rs.getString("book_title"))
						.build();
//				@formatter:on
			}
		});
	
		}
}
