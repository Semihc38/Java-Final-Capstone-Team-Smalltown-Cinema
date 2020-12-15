package com.techelevator.application.model;

public class Order {

	private int orderId;
	private String username;
	private String fullName;
	private String email;
	private String billingAddress;
	private int showtimeId;
	private String seats;
	private int totalCost;
	
	public Order() {
		
	}
	
	public Order(int orderId, String username, String fullName, String email, String billingAddress, int showtimeId,
			String seats, int totalCost) {
		
		this.orderId = orderId;
		this.username = username;
		this.fullName = fullName;
		this.email = email;
		this.billingAddress = billingAddress;
		this.showtimeId = showtimeId;
		this.seats = seats;
		this.totalCost = totalCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
	
}
