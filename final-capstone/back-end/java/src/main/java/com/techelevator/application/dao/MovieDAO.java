package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Movie;

public interface MovieDAO {

	
	public List<Movie> getAllFeaturedMovies();
	
	public Movie getChosenMovie(Integer id);
	
	public Movie getMovieByShowtimeId(int id);
}



