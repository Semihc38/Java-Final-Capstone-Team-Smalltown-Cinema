package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.application.dao.ShowtimesDAO;
import com.techelevator.application.model.Showtimes;

@Component
public class JDBCShowtimesDAO implements ShowtimesDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCShowtimesDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Showtimes> getShowtimesByMovieId(int id) {
		String query = "SELECT * FROM showtimes WHERE movie_id = ?";

		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		List<Showtimes> showtimes = new ArrayList<>();
		
		while (rowSet.next()) {
			Showtimes showtime = mapRowToShowtimes(rowSet);
			showtimes.add(showtime);
		}
		
		return showtimes;
		
		
	}
	
	@Override
	public List<Showtimes> getShowtimesByMovieIdAndDayOfWeek(int id, String dayofweek) {
		String query = "SELECT * FROM showtimes WHERE movie_id = ? AND dayofweek = ?";

		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id, dayofweek);
		
		List<Showtimes> showtimes = new ArrayList<>();
		
		while (rowSet.next()) {
			Showtimes showtime = mapRowToShowtimes(rowSet);
			showtimes.add(showtime);
		}
		
		return showtimes;
		
		
	}
	
	
	private Showtimes mapRowToShowtimes(SqlRowSet rowset) {
		Showtimes showtimes = new Showtimes();
		
	    showtimes.setShowtimeId(rowset.getInt("showtime_id"));
		showtimes.setMovieId(rowset.getInt("movie_id"));
		showtimes.setTheaterId(rowset.getInt("theater_id"));
		showtimes.setStartTime(rowset.getString("start_time"));
		showtimes.setDayofweek(rowset.getString("dayofweek"));

		return showtimes;
	}
	
}
