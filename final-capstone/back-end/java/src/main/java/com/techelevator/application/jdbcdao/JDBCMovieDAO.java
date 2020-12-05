package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.MovieDAO;
import com.techelevator.application.model.Movie;



@Component
public class JDBCMovieDAO implements MovieDAO {

	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCMovieDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Movie> getAllFeaturedMovies() {
		String query = "SELECT * FROM movies WHERE isFeatured = true";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);

		List<Movie> movies = new ArrayList<>();

		while (rowSet.next()) {
			Movie movie = mapRowToMovie(rowSet);
			movies.add(movie);
		}

		return movies;
	}
	
	
	
	
	
	
	private Movie mapRowToMovie(SqlRowSet rowset) {
		Movie movie = new Movie();
		movie.setMovieId(rowset.getInt("movie_id"));
		movie.setTitle(rowset.getString("title"));
		movie.setReleaseDate(rowset.getString("release_date"));
		movie.setFeatured(rowset.getBoolean("isfeatured"));
		movie.setOverview(rowset.getString("overview"));

		return movie;
	}
}
