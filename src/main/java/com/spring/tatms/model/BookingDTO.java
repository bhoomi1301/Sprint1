package com.spring.tatms.model;

import java.sql.Time;
import java.util.Date;

import com.spring.tatms.entity.Customer;
import com.spring.tatms.entity.Payment;
import com.spring.tatms.entity.TravelAgent;


public class BookingDTO {

	private int book_id;
	private boolean book_status;
	private Time book_time;
	private Date book_date;
	
	private Customer customer;
	
	private TravelAgent travelAgent;
	
	private Payment payment;
	
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
	public BookingDTO(int book_id, boolean book_status, Time book_time, Date book_date) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
	}
	
	public BookingDTO(int book_id, boolean book_status, Time book_time, Date book_date, Customer customer) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
		this.customer = customer;
	}
	
	public BookingDTO(int book_id, boolean book_status, Time book_time, Date book_date, TravelAgent travelAgent) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
		this.travelAgent = travelAgent;
	}

	public BookingDTO(int book_id, boolean book_status, Time book_time, Date book_date, Payment payment) {
		super();
		this.book_id = book_id;
		this.book_status = book_status;
		this.book_time = book_time;
		this.book_date = book_date;
		this.payment = payment;
	}
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
