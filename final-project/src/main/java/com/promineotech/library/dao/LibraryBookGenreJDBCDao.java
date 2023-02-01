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

import com.promineotech.library.entity.Book_Genre;

/**
 * @author Bryce Cash
 *
 */
@Repository
public class LibraryBookGenreJDBCDao implements LibraryBookGenreDao {
	private NamedParameterJdbcTemplate provider;
	public LibraryBookGenreJDBCDao(NamedParameterJdbcTemplate provider) {
		this.provider =provider;
	}
	@Override
	public List<Book_Genre> fetchBooksByGenre(String genre_name) {
//		@formatter:off
		String sql = "SELECT g.genre_name , b.book_title "  
				+ "FROM genre g "
				+ "INNER JOIN books_genre bg on g.genre_id  = bg.genre_id "
				+ "INNER JOIN books b on bg.book_isbn = b.book_isbn "
				+ "WHERE genre_name = :genre_name;";
//		@formatter:on
		Map<String, Object> params = new HashMap<>();
		params.put("genre_name", genre_name);
		
		return provider.query(sql, params, new RowMapper<>() {

			@Override
			public Book_Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
//				@formatter:off
				return Book_Genre.builder()
				.book_title(rs.getString("book_title"))
				.genre_name(rs.getString("genre_name"))
				.build();
//				@formatter:on
				
			}
		});
	}

}
