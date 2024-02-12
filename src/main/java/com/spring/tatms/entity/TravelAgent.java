package com.spring.tatms.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "travel_agents")
public class TravelAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ta_id;
	
	@Column(name = "ta_name", nullable = false)
	private String ta_name;
	
	@Column(name = "ta_email", nullable = false)
	private String ta_email;

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

	public TravelAgent(int ta_id, String ta_name, String ta_email) {
		super();
		this.ta_id = ta_id;
		this.ta_name = ta_name;
		this.ta_email = ta_email;
	}
	
	public TravelAgent(int ta_id, String ta_name, String ta_email, List<Booking> bookings) {
		super();
		this.ta_id = ta_id;
		this.ta_name = ta_name;
		this.ta_email = ta_email;
		this.bookings = bookings;
	}

	// One travel agent can make multiple bookings -> (One-to-Many)
	@OneToMany(mappedBy="travelAgent",cascade=CascadeType.PERSIST) // travel agent id will be foreign key
	@JsonIgnoreProperties("travelAgent")
	List<Booking> bookings;  //  in booking table

	public TravelAgent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
