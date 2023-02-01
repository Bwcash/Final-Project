/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.library.entity.Books;
import com.promineotech.library.entity.Review;
import com.promineotech.library.entity.ReviewInput;
import com.promineotech.library.entity.Review_Books;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Bryce Cash
 *
 */
public interface IReviewController {
@PostMapping(value ="/reviews/create/{book_isbn}")	
	//@formatter:off
	  @Operation(
	      summary = "Returns a created review by id",
	      description = "returns a created review with a specific id ",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A review is returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = ReviewInput.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No review was created", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(mediaType = "application/json"))
	      },
	  	      parameters = {
	  	          @Parameter(
	  	              name = "review_text", 
	  	              allowEmptyValue = false, 
	  	              required = false, 
	  	              description = "The review you would like to add."),
	  	        @Parameter(
		  	              name = "book_isbn", 
		  	              allowEmptyValue = false, 
		  	              required = false, 
		  	              description = "The book ISBN for the review.")
	      }
	      )
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Review> createReview(
			  @RequestParam(required = false) String review_text,
			  @Length(min = 17, max = 17)
			  @Pattern(regexp= "[0-9_]*")
			  @RequestParam(required = false) String book_isbn) throws  Throwable;
	
	 //	      @formatter:on
@GetMapping(value ="/reviews/bytitle/{book_title}")	
	//@formatter:off
	  @Operation(
	      summary = "Returns a list of reviews by book",
	      description = "returns a list of review for a specific book in the library ",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A list of reviews is returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Review_Books.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No reviews were found", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(mediaType = "application/json"))
	      },
	  	      parameters = {
	  	          @Parameter(
	  	              name = "book_title", 
	  	              allowEmptyValue = false, 
	  	              required = false, 
	  	              description = "The title of the book (i.e., 'Awake')")
	      }
	      )
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Review_Books> fetchReviewByBook(
			  @RequestParam(required = false) String book_title);
	
	 //	      @formatter:on
	
@GetMapping(value ="/reviews/byId/{review_id}")	
	//@formatter:off
	  @Operation(
	      summary = "Returns a review by id",
	      description = "returns a  review with a specific id ",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A review is returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Review.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No review with that id  was found", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(mediaType = "application/json"))
	      },
	  	      parameters = {
	  	          @Parameter(
	  	              name = "review_id", 
	  	              allowEmptyValue = false, 
	  	              required = false, 
	  	              description = "The review id (i.e., '1')")
	      }
	      )
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Review> fetchReviewById(
			  @RequestParam(required = false) Integer review_id);
	
	 //	      @formatter:on
	
@PutMapping(value ="/reviews/update/{review_id}")
	  	//@formatter:off
	  	  @Operation(
	  	      summary = "Returns a updated review",
	  	      description = "returns a review with the  updated inputted text ",
	  	      responses = {
	  	          @ApiResponse(
	  	              responseCode = "200", 
	  	              description = "A updated review is returned", 
	  	              content = @Content(
	  	                  mediaType = "application/json", 
	  	                  schema = @Schema(implementation = Review.class))),
	  	          @ApiResponse(
	  	              responseCode = "400", 
	  	              description = "The request parameters are invalid", 
	  	              content = @Content(mediaType = "application/json")),
	  	          @ApiResponse(
	  	              responseCode = "404", 
	  	              description = "The Review to update was not found", 
	  	              content = @Content(mediaType = "application/json")),
	  	          @ApiResponse(
	  	              responseCode = "500", 
	  	              description = "An unplanned error occurred.", 
	  	              content = @Content(mediaType = "application/json"))
	  	      },
	  	      parameters = {
	  	          @Parameter(
	  	              name = "review_id", 
	  	              allowEmptyValue = false, 
	  	              required = false, 
	  	              description = "The review Id(i.e., '1')"),
	  	          @Parameter(
	  	        		  name = "review_text",
	  	        		  allowEmptyValue = false,
	  	        		  required = false,
	  	        		  description = "The review text you would like to leave(i.e., 'This book was scary')")
	  	      }

	  	      )
	  	  @ResponseStatus(code = HttpStatus.OK)
	  	  List<Review> updateReview(
	  			  @RequestParam(required = false)Integer review_id,
	  	  		@RequestParam(required = false) String review_text);
//	  	      @formatter:on
	 

@DeleteMapping(value ="/reviews/delete/{review_id}")	
	//@formatter:off
		@Operation(
				summary = "Deletes a review by id",
				description = "deletes a review with a specific id ",
				responses = {
					@ApiResponse(
						responseCode = "200", 
						description = "A review was deleted", 
						content = @Content(
								mediaType = "application/json")),
					@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(mediaType = "application/json")
								),
					@ApiResponse(
						responseCode = "404", 
						description = "No review with that id  was found", 
						content = @Content(mediaType = "application/json")),
					@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))
      },
				parameters = {
						@Parameter(
							name = "review_id", 
							allowEmptyValue = false, 
							required = false, 
							description = "The review id (i.e., '1')")
      }
      )
  @ResponseStatus(code = HttpStatus.OK)
  String deleteReviewById(
		  @RequestParam(required = false) Integer review_id);

 //	      @formatter:on
}

