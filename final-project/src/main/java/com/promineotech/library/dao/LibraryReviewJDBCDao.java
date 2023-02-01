/**
 * 
 */
package com.promineotech.library.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.validation.ConstraintViolationException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.promineotech.library.entity.Review;
import com.promineotech.library.entity.ReviewInput;
import com.promineotech.library.entity.Review_Books;

/**
 * @author Bryce Cash
 *
 */
@Repository
public class LibraryReviewJDBCDao implements LibraryReviewDao {
private NamedParameterJdbcTemplate provider;
public LibraryReviewJDBCDao(NamedParameterJdbcTemplate provider) {
	this.provider = provider;
}

	@Override
	public List<Review> createReview(String review_text, String book_isbn) throws Exception  {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParams params = generateInsertSql(review_text,  book_isbn);
		provider.update(params.sql, params.source, keyHolder);
		Number reviewID = keyHolder.getKey();
		Integer newId = reviewID.intValue();

		if(newId != null)  {
		 return  fetchReviewById(newId);
	}
		String msg = "Unplanned erorr the review was not created";
		throw new Exception(msg);
		
	}

	private SqlParams generateInsertSql(String review_text, String book_isbn) {
		 SqlParams params = new SqlParams();
//	    @formatter:off
	    params.sql = "INSERT INTO review (review_text, book_isbn) "
				+ "VALUES ( :review_text, :book_isbn) ";
//	    @formatter:on
	    params.source.addValue("review_text", review_text);
	    params.source.addValue("book_isbn", book_isbn);
	    
	    return params;
	  }

	@Override
	public List<Review_Books> fetchReviewByBook(String book_title) {
//		@formatter:off
		String sql = "SELECT r.* , b.book_title "
				+ "FROM review r "
				+ "INNER JOIN books b ON r.book_isbn = b.book_isbn "
				+ "WHERE b.book_title = :book_title ";
//		@formatter:on
		Map<String, Object> params = new HashMap<>();
		params.put("book_title", book_title);
		
		return provider.query(sql, params, new RowMapper<>() {

			@Override
			public Review_Books mapRow(ResultSet rs, int rowNum) throws SQLException {
//				@formatter:off
				return Review_Books.builder()
						.review_id(rs.getInt("review_id"))
						.review_text(rs.getString("review_text"))
						.book_isbn(rs.getString("book_isbn"))
						.book_title(rs.getString("book_title"))
						.build();
//				@formatter:on
			}
		});
	}

	@Override
	public List<Review> fetchReviewById(Integer review_id) {
//		@formatter:off
		String sql = "SELECT  r.* "
				+ "FROM review r "
				+ "WHERE review_id = :review_id ";
//		@formatter:on
		Map<String, Object> params = new HashMap<>();
		params.put("review_id", review_id);
		
		return provider.query(sql, params, new RowMapper<>() {

			@Override
			public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Review.builder()
						.review_id(rs.getInt("review_id"))
						.review_text(rs.getString("review_text"))
						.book_isbn(rs.getString("book_isbn"))
						.build();
			}
		});
	}

	@Override
	public List<Review> updateReview(Integer review_id, String review_text) {
//		@formatter:on
		String sql = "UPDATE review "
				+ "SET review_text = :review_text "
				+ "WHERE review_id  = :review_id ";
//		@formatter:off
		Map<String, Object> params = new HashMap<>();
		params.put("review_id", review_id);
		params.put("review_text", review_text);
		
		int rows = provider.update(sql, params);
		if(rows != 1) {
			String msg = String.format("Review text '%s' with review Id '%d' was not updated", review_text, review_id);
			throw new ConstraintViolationException(msg, null);
		}
			return fetchReviewById(review_id);	
		
	}

	@Override
	public String deleteReviewById(Integer review_id) {
//		@formatter:off
		String sql = "DELETE from review "
					+ "WHERE review_id = :review_id ";
//		@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("review_id", review_id);
		
		int rows = provider.update(sql, params);
		if(rows !=1) {
			String msg = String.format("Review Id '%s' was not deleted",  review_id);
			throw new ConstraintViolationException(msg, null);
		}
		String msg = String.format("The review with review Id '%d' was deleted.", review_id);
		return msg;
	}

	class SqlParams{
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }
}
