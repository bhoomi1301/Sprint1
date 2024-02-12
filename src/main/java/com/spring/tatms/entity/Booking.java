package com.spring.tatms.entity;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	
	@Column(name = "booking_status", nullable = false)
	private boolean book_status;
	
	@Column(name = "booking_time", nullable = false)
	private Time book_time;
	
	@Column(name = "booking_date", nullable = false)
	private Date book_date;
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public TravelAgent getTravelAgent() {
		return travelAgent;
	}

	public void setTravelAgent(TravelAgent travelAgent) {
		this.travelAgent = travelAgent;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public boolean isBook_status() {
		return book_status;
	}

	public void setBook_status(boolean book_status) {
		this.book_status = book_status;
	}

	public Time getBook_time() {
		return book_time;
	}

	public void setBook_time(Time book_time) {
		this.book_time = book_time;
	}

	public Date getBook_date() {
		return book_date;
	}

	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}

	public Booking(int book_id, boolean book_status, Time book_time, Date book_date) { 
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
	}

	public Booking(int book_id, boolean book_status, Time book_time, Date book_date, Customer customer) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
		this.customer = customer;
	}
	
	public Booking(int book_id, boolean book_status, Time book_time, Date book_date, TravelAgent travelAgent) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
		this.travelAgent = travelAgent;
	}
	
	public Booking(int book_id, boolean book_status, Time book_time, Date book_date, Payment payment) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
		this.payment = payment;
	}



	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cus_id")
	@JsonIgnoreProperties("bookings")
	private Customer customer;        //Multiple bookings can be made by single customer -> (Many-to-One)
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ta_id")
	@JsonIgnoreProperties("bookings")
	private TravelAgent travelAgent; // Multiple bookings can be made by single travel agent -> (Many-To-One)
	
	// A Booking can have only one payment -> (One-to-One)
	@OneToOne(mappedBy="booking",cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties("booking")
	private Payment payment;
	

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
