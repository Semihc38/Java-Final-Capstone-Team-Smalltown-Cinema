package com.techelevator.application.model;

public class Showtimes {

	private int showtimeId;
	private int movieId;
	private int theaterId;
	private String startTime;
	private String dayofweek;
	
	public Showtimes() {
	}

	public Showtimes(int showtimeId, int movieId, int theaterId, String startTime, String dayofweek) {
	
		this.showtimeId = showtimeId;
		this.movieId = movieId;
		this.theaterId = theaterId;
		this.startTime = startTime;
		this.dayofweek = dayofweek;
	
	
	
	}
	

	public String getDayofweek() {
		return dayofweek;
	}

	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
	}

	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
		
	
	
}
