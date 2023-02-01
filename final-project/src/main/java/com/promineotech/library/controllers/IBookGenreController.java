/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.library.entity.Author_Books;
import com.promineotech.library.entity.Book_Genre;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Bryce Cash
 *
 */
public interface IBookGenreController {
	@GetMapping(value = "/book_genres/{genre_name}/books")
	 //@formatter:off
	@Operation(
	    summary = "Returns a list of Books by Genre name",
	    description = "returns a list of Books with a specific genre name in the library ",
	    responses = {
	        @ApiResponse(
	            responseCode = "200", 
	            description = "A list of Books is returned", 
	            content = @Content(
	                mediaType = "application/json", 
	                schema = @Schema(implementation = Book_Genre.class))),
	        @ApiResponse(
	            responseCode = "400", 
	            description = "The request parameters are invalid", 
	            content = @Content(mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "404", 
	            description = "No Books were found by that genre", 
	            content = @Content(mediaType = "application/json")),
	        @ApiResponse(
	            responseCode = "500", 
	            description = "An unplanned error occurred.", 
	            content = @Content(mediaType = "application/json"))
	    },
	      parameters = {
	          @Parameter(
	              name = "genre_name", 
	              allowEmptyValue = false, 
	              required = false, 
	              description = "The Genre Name (i.e.,'horror')")
	      }

	      )
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Book_Genre> fetchBooksByGenre(
			  @Pattern(regexp= "^[a-zA-Z0-9.\\-\\/+=@_ ]*$")
			  @RequestParam(required = false) String genre_name);
//	      @formatter:on
	  }

