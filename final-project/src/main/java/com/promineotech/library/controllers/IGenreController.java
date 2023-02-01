/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.library.entity.Genre;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Bryce Cash
 *
 */
public interface IGenreController {
@GetMapping(value ="/genres")	
	//@formatter:off
	  @Operation(
	      summary = "Returns a list of all Genres",
	      description = "returns a list of Genres of books in the library ",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A list of Genres is returned", 
	              content = @Content(
	                  mediaType = "application/json", 
	                  schema = @Schema(implementation = Genre.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No Genres were found", 
	              content = @Content(mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(mediaType = "application/json"))
	      }
	      
//	      @formatter:on
	      )
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Genre> fetchAllGenres();
}
