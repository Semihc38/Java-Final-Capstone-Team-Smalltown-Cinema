package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Seat;

public interface SeatDAO {

	public void generateSeats();
	
	public List<Seat> getSeatByShowtime(int showtimeId);
}
