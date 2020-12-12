package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
	
	
	@Override
	public void bookSeat(int showtimeId, String seatName) {
			String query = "UPDATE seats SET is_booked = true WHERE showtime_id = ? AND seat_name = ?";
			jdbcTemplate.update(query, showtimeId, seatName);
			
		}
	
	
	@Override
	public List<Seat> getSeatByShowtime(int showtimeId) {
		String query = "SELECT * FROM seats WHERE showtime_id = ? AND is_booked = false";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, showtimeId);
		
		List<Seat> seats = new ArrayList<>();
		
		while(rowSet.next()) {
			Seat seat = mapRowToSeat(rowSet);
			seats.add(seat);
		}
		return seats;
	}
	

	
	private char getLetterFromNum(int num) {
		return (char) (num+'A'-1);
	}
	

private Seat mapRowToSeat(SqlRowSet rowSet) {
	Seat seat = new Seat();
	
	seat.setName(rowSet.getString("seat_name"));
	seat.setShowtimeId(rowSet.getInt("showtime_id"));
	seat.setBooked(rowSet.getBoolean("is_booked"));

	return seat;
}


	
}
