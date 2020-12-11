package com.techelevator.application.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.SeatDAO;

@RestController
@CrossOrigin
public class SeatController {
	
	private SeatDAO seatDao;
	
	public SeatController(SeatDAO seatDao) {
		this.seatDao=seatDao;
	}
	
	@RequestMapping(path="/seatCreation/", method = RequestMethod.POST)
	public void generateSeats() {
		seatDao.generateSeats();
	}

}
