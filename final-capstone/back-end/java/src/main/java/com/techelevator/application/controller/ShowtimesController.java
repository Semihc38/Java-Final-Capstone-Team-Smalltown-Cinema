package com.techelevator.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.application.dao.ShowtimesDAO;
import com.techelevator.application.model.Showtimes;

@RestController
@CrossOrigin
public class ShowtimesController {
	
	private ShowtimesDAO showtimesDao;
	
	public ShowtimesController(ShowtimesDAO showtimesDao) {
		this.showtimesDao=showtimesDao;
	}
	
	@RequestMapping(path = "/showtimes/{id}", method = RequestMethod.GET)
	public List<Showtimes> getShowtimesByMovieId(@PathVariable int id){
		return showtimesDao.getShowtimesByMovieId(id); 
	}
}
