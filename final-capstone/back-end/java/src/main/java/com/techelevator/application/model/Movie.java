package com.techelevator.application.model;

public class Movie {
	
	private int movieId;
	private String title;
	private String releaseDate;
	private boolean isFeatured;
	private String overview;
	private String poster;
	
	public Movie() {
	}
	
	
	public Movie(int movieId, String title, String releaseDate, boolean isFeatured, String overview, String poster) {
		
		this.movieId = movieId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.isFeatured = isFeatured;
		this.overview = overview;
		this.poster = poster;
		
	}
	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isFeatured() {
		return isFeatured;
	}

	public void setFeatured(boolean isFeatured) {
		this.isFeatured = isFeatured;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	
	
	


}
