package com.techelevator.application.dao;

import java.util.List;

import com.techelevator.application.model.Order;

public interface OrderDAO {

	
	public List<Order> getAllOrdersByUsername();
	
	public Order getOrderByOrderId(int id);
}
