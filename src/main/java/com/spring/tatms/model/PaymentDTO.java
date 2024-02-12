package com.spring.tatms.model;

import java.util.Date;

import com.spring.tatms.entity.Booking;

public class PaymentDTO {

	private int pay_id;
	private double pay_amt;
	private Date pay_date;
	private Boolean pay_status;
	
	private Booking booking;
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public double getPay_amt() {
		return pay_amt;
	}
	public void setPay_amt(double pay_amt) {
		this.pay_amt = pay_amt;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public Boolean getPay_status() {
		return pay_status;
	}
	public void setPay_status(Boolean pay_status) {
		this.pay_status = pay_status;
	}
	public PaymentDTO(int pay_id, double pay_amt, Date pay_date, Boolean pay_status) {
		super();
		this.pay_id = pay_id;
		this.pay_amt = pay_amt;
		this.pay_date = pay_date;
		this.pay_status = pay_status;
	}
	
	public PaymentDTO(int pay_id, double pay_amt, Date pay_date, Boolean pay_status, Booking booking) {
		super();
		this.pay_id = pay_id;
		this.pay_amt = pay_amt;
		this.pay_date = pay_date;
		this.pay_status = pay_status;
		this.booking = booking;
	}
	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
