/**
 * 
 */
package com.promineotech.library.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Service;

import com.promineotech.library.dao.LibraryReviewDao;
import com.promineotech.library.entity.Review;
import com.promineotech.library.entity.ReviewInput;
import com.promineotech.library.entity.Review_Books;

/**
 * @author Bryce Cash
 *
 */
@Service
public class DefaultLibraryReviewService implements LibraryReviewService {
private LibraryReviewDao reviewDao;
public DefaultLibraryReviewService(LibraryReviewDao reviewDao) {
	this.reviewDao =reviewDao;
}
	@Override
	public List<Review> createReview(String review_text, String book_isbn) throws Exception, Throwable {
		if((review_text != null) && (book_isbn != null)) {
			if(book_isbn.length() != 17) {
				String msg3 = String.format("Invlaid book ISBN, must be 17 characters. " ,book_isbn);
				throw new ConstraintViolationException(msg3, null);
			}
			List<Review> create = reviewDao.createReview(review_text, book_isbn);
			if(create.isEmpty()) {
				String msg1 = String.format("Unplanned Error, review not created", review_text);
			throw new Exception(msg1);
			}
			return create;
		}
		String msg2 = String.format("Invlaid review, missing fields " ,review_text);
		throw new ConstraintViolationException(msg2, null);
	}

	@Override
	public List<Review_Books> fetchReviewByBook(String book_title) {
		if(book_title != null) {
			List<Review_Books> bookReview = reviewDao.fetchReviewByBook(book_title);
		if(bookReview.isEmpty()) {
			String msg1 = String.format("No reviews for book title: '%s' were found", book_title);
			throw new NoSuchElementException(msg1);
		}
		return bookReview;
		}
		String msg2 = String.format("Book title cannot be blank" ,book_title);
			throw new ConstraintViolationException(msg2, null);
	}

	@Override
	public List<Review> fetchReviewById(Integer review_id) {
		if(review_id != null) {
			List<Review> review = reviewDao.fetchReviewById(review_id);
		if(review.isEmpty()) {
			String msg1 = String.format("No reviews with review Id: '%s' were found", review_id);
			throw new NoSuchElementException(msg1);
		}
		return review;
		}
		String msg2 = String.format("Review Id cannot be blank" ,review_id);
			throw new ConstraintViolationException(msg2, null);
	}	
	

	@Override
	public List<Review> updateReview(Integer review_id, String review_text) {
		if((review_id == null) || (review_text == null)) {
			String msg1 = String.format("You must enter a review Id and a review text", review_id);
			throw new ConstraintViolationException(msg1, null);
		}
		return reviewDao.updateReview(review_id, review_text);
	}

	@Override
	public String deleteReviewById(Integer review_id) {
		if(review_id != null) {
			return reviewDao.deleteReviewById(review_id);
		}
		throw new ConstraintViolationException("Review Id cannot be blank", null);
	}

}
