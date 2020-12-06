package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Showtimes;

public interface ShowtimesDAO {

	public List<Showtimes> getShowtimesByMovieId(int id);
}