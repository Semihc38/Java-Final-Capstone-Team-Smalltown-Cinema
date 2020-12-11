package com.techelevator.application.jdbcdao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.SeatDAO;
import com.techelevator.application.model.Seat;
@Component
public class JDBCSeatDAO implements SeatDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCSeatDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	
	@Override
	public void generateSeats() {
		Seat seat = new Seat();
	for(int q = 1; q<57;q++) {
		for(int i = 1; i<7; i++) {
			for(int j = 1; j<5;j++) {
				String seatName = String.valueOf(getLetterFromNum(i))+j;
				seat.setName(seatName);
				seat.setBooked(false);
				seat.setShowtimeId(q);
				String query = "INSERT INTO seats (seat_name, showtime_id, is_booked) VALUES (?,?,?)";
				jdbcTemplate.update(query, seat.getName(), seat.getShowtimeId(), seat.isBooked());
			}
		}
	}
	}
	
	private char getLetterFromNum(int num) {
		return (char) (num+'A'-1);
	}

}
