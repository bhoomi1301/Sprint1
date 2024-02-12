package com.spring.tatms.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pay_id;
	
	@Column(name = "pay_amt", nullable = false)
	private double pay_amt;
	
	@Column(name = "pay_date", nullable = false)
	private Date pay_date;
	
	@Column(name = "pay_status", nullable = false)
	private Boolean pay_status;

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

	public Payment(int pay_id, double pay_amt, Date pay_date, Boolean pay_status) {
		super();
		this.pay_id = pay_id;
		this.pay_amt = pay_amt;
		this.pay_date = pay_date;
		this.pay_status = pay_status;
	}

	public Payment(int pay_id, double pay_amt, Date pay_date, Boolean pay_status, Booking booking) {
		super();
		this.pay_id = pay_id;
		this.pay_amt = pay_amt;
		this.pay_date = pay_date;
		this.pay_status = pay_status;
		this.booking = booking;
	}
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="book_id")
	@JsonIgnoreProperties("payment")
	private Booking booking; // A payment can be associated with only one booking

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
