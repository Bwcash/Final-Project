/**
 * 
 */
package com.promineotech.library.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.library.entity.Genre;
import com.promineotech.library.service.LibraryGenreService;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Bryce Cash
 *
 */
@Tag(name = "Genre Controller")
@RestController
public class GenreController implements IGenreController {
private LibraryGenreService genreService;
public GenreController(LibraryGenreService genreService) {
	this.genreService = genreService;
}
	@Override
	public List<Genre> fetchAllGenres() {
	return genreService.fetchAllGenres();
	}

}
