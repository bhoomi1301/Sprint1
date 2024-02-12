package com.spring.tatms.model;

import java.util.List;

import com.spring.tatms.entity.Booking;

public class TravelAgentDTO {

	private int ta_id;
	private String ta_name;
	private String ta_email;
	
	List<Booking> bookings;
	
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public int getTa_id() {
		return ta_id;
	}
	public void setTa_id(int ta_id) {
		this.ta_id = ta_id;
	}
	public String getTa_name() {
		return ta_name;
	}
	public void setTa_name(String ta_name) {
		this.ta_name = ta_name;
	}
	public String getTa_email() {
		return ta_email;
	}
	public void setTa_email(String ta_email) {
		this.ta_email = ta_email;
	}
	public TravelAgentDTO(int ta_id, String ta_name, String ta_email) {
		super();
		this.ta_id = ta_id;
		this.ta_name = ta_name;
		this.ta_email = ta_email;
	}
	
	public TravelAgentDTO(int ta_id, String ta_name, String ta_email, List<Booking> bookings) {
		super();
		this.ta_id = ta_id;
		this.ta_name = ta_name;
		this.ta_email = ta_email;
		this.bookings = bookings;
	}
	public TravelAgentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
