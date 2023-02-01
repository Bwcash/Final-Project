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

import com.promineotech.library.entity.Genre;

/**
 * @author Bryce Cash
 *
 */
@Repository
public class LibraryGenreJDBCDao implements LibraryGenreDao {
	private NamedParameterJdbcTemplate provider;
	public LibraryGenreJDBCDao(NamedParameterJdbcTemplate provider) {
		this.provider = provider;
	}
	@Override
	public List<Genre> fetchAllGenres() {
//		@formatter:off
		String sql ="select * "
				+ "FROM genre; ";
//		@formatter:off
		Map<String, Object> params = new HashMap<>();
		
		return provider.query(sql, params, new RowMapper<>() {

			@Override
			public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
//				@formatter:off
				return Genre.builder()
						.genre_id(rs.getInt("genre_id"))
						.genre_name(rs.getString("genre_name"))
						.build();
//				@formatter:on
			}
		});
	}

}
