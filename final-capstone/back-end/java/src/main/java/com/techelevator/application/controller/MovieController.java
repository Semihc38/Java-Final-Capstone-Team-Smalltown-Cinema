package com.techelevator.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.MovieDAO;
import com.techelevator.application.model.Movie;



@RestController
@CrossOrigin
public class MovieController {
	
	private MovieDAO movieDao;
	
	public MovieController(MovieDAO movieDao) {
		this.movieDao = movieDao;
	}
	
	@RequestMapping(path = "/featuredMovies", method = RequestMethod.GET)
	public List<Movie> getAllFeaturedMovies() {
		return movieDao.getAllFeaturedMovies();
	}

	@RequestMapping(path = "/featuredMovies/{id}", method = RequestMethod.GET)
	public Movie getChosenMovie(@PathVariable Integer id) {
		return movieDao.getChosenMovie(id);
	}
}
