/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.library.entity.Review;
import com.promineotech.library.entity.ReviewInput;
import com.promineotech.library.entity.Review_Books;
import com.promineotech.library.service.LibraryReviewService;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Bryce Cash
 *
 */
@Tag(name = "Review Controller")
@RestController
public class ReviewController implements IReviewController{
private LibraryReviewService reviewService;
public ReviewController(LibraryReviewService reviewService) {
	this.reviewService = reviewService;
}
	@Override
	public List<Review> createReview(String review_text, String book_isbn) throws Throwable {
		return reviewService.createReview(review_text, book_isbn);
	}

	@Override
	public List<Review_Books> fetchReviewByBook(String book_title) {
		return reviewService.fetchReviewByBook(book_title);
	}

	@Override
	public List<Review> fetchReviewById(Integer review_id) {
		return reviewService.fetchReviewById(review_id);
	}

	@Override
	public List<Review> updateReview(Integer review_id, String review_text) {
		return reviewService.updateReview(review_id, review_text);
	}

	@Override
	public String deleteReviewById(Integer review_id) {
		return reviewService.deleteReviewById(review_id);
	}

}
