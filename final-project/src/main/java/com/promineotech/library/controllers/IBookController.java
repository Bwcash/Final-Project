/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.library.entity.Books;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Bryce Cash
 *
 */

@OpenAPIDefinition(info = @Info(title = "Mrs. Cash's library"))
public interface IBookController {
@GetMapping(value ="/books")	
	//@formatter:off
	  @Operation(
	      summary = "Returns a list of all Books",
	      description = "returns a list of Books in the library ",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A list of Books is returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Books.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No Books were found", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(mediaType = "application/json"))
	      }
	      
//	      @formatter:on
	      )
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Books> fetchAllBooks();
	 
@PutMapping(value ="/books/{book_name}/book_status")
	  	//@formatter:off
	  	  @Operation(
	  	      summary = "Returns a Book with an update status",
	  	      description = "returns a Book with the inputted status ",
	  	      responses = {
	  	          @ApiResponse(
	  	              responseCode = "200", 
	  	              description = "A  Book with updated status is returned", 
	  	              content = @Content(
	  	                  mediaType = "application/json", 
	  	                  schema = @Schema(implementation = Books.class))),
	  	          @ApiResponse(
	  	              responseCode = "400", 
	  	              description = "The request parameters are invalid", 
	  	              content = @Content(mediaType = "application/json")),
	  	          @ApiResponse(
	  	              responseCode = "404", 
	  	              description = "The Book to update was not found", 
	  	              content = @Content(mediaType = "application/json")),
	  	          @ApiResponse(
	  	              responseCode = "500", 
	  	              description = "An unplanned error occurred.", 
	  	              content = @Content(mediaType = "application/json"))
	  	      },
	  	      parameters = {
	  	          @Parameter(
	  	              name = "book_status", 
	  	              allowEmptyValue = false, 
	  	              required = false, 
	  	              description = "The book's status (i.e., 'In' or 'Out' )"),
	  	          @Parameter(
	  	              name = "book_title",
	  	              allowEmptyValue = false, 
	  	              required = false, 
	  	              description = "The title of the book (i.e., 'Awake')")
	  	      }

	  	      )
	  	  @ResponseStatus(code = HttpStatus.OK)
	  	  List<Books> updateBookStatus(
	  			  @RequestParam(required = false)String book_status,
	  			  @RequestParam(required = false) String book_title);
//	  	      @formatter:on
	  	  }

	

