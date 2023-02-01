/**
 * 
 */
package com.promineotech.library.dao;

import java.util.List;

import com.promineotech.library.entity.Review;
import com.promineotech.library.entity.ReviewInput;
import com.promineotech.library.entity.Review_Books;

/**
 * @author Bryce Cash
 *
 */
public interface LibraryReviewDao {

	List<Review> createReview(String review_text, String book_isbn) throws Throwable;

	List<Review_Books> fetchReviewByBook(String book_title);

	List<Review> fetchReviewById(Integer review_id);

	List<Review> updateReview(Integer review_id, String review_text);

	String deleteReviewById(Integer review_id);

}
