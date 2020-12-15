package com.techelevator.application.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.application.dao.OrderDAO;
import com.techelevator.application.model.Order;


@Component
public class JDBCOrderDAO implements OrderDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCOrderDAO(DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Order> getAllOrdersByUsername(String username) {
		String query = "SELECT * FROM orders WHERE username = ?";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, username);
		
		List<Order> orders = new ArrayList<>();
		
		while (rowSet.next()) {
			Order order = mapRowToOrder(rowSet);
			orders.add(order);
		}
		return orders;
		
	}
	
	@Override
	public Order getOrderByOrderId(int id) {
		
		String query = "SELECT * FROM orders WHERE order_id = ?";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, id);
		
		Order order = new Order();
		
		if (rowSet.next()) {
			order = mapRowToOrder(rowSet);
		}
		return order;
	}
	
	
	
	
	private Order mapRowToOrder(SqlRowSet rowset) {
		Order order = new Order();
		
		order.setOrderId(rowset.getInt("order_id"));
		order.setUsername(rowset.getString("username"));
		order.setFullName(rowset.getString("full_name"));
		order.setEmail(rowset.getString("email"));
		order.setBillingAddress(rowset.getString("billing_address"));
		order.setShowtimeId(rowset.getInt("showtime_id"));
		order.setSeats(rowset.getString("seats"));
		order.setTotalCost(rowset.getInt("total_cost"));
		
		return order;
	}
	
}
