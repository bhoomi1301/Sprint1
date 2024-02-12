package com.spring.tatms.entity;
import java.util.ArrayList;
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
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cus_id;
	
	@Column(name = "customer_name", nullable = false, length=50)
	private String cus_name;
	
	@Column(name = "address",length=100)
	private String cus_addr;
	
	@Column(name = "email")
	private String cus_email;
	
	@Column(name = "password")
	private String cus_password;
	
	@Column(name = "phn_no")
	private String phno;

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_addr() {
		return cus_addr;
	}

	public void setCus_addr(String cus_addr) {
		this.cus_addr = cus_addr;
	}

	public String getCus_email() {
		return cus_email;
	}

	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}

	public String getCus_password() {
		return cus_password;
	}

	public void setCus_password(String cus_password) {
		this.cus_password = cus_password;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public List<TourPackage> getTourPackages() {
		return tourPackages;
	}

	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
	}

	public Customer(int cus_id, String cus_name, String cus_addr, String cus_email, String cus_password, String phno) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.cus_password = cus_password;
		this.phno = phno;
	}

	public Customer(int cus_id, String cus_name, String cus_addr, String cus_email, String cus_password, String phno,
			List<TourPackage> tourPackages) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.cus_password = cus_password;
		this.phno = phno;
		this.tourPackages = tourPackages;
	}

	public Customer(int cus_id, String cus_name, String cus_addr, String cus_email, String cus_password, String phno,
			ArrayList<Booking> bookings) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.cus_password = cus_password;
		this.phno = phno;
		this.bookings = bookings;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	// One customer can book multiple packages -> (One-to-Many)
	@OneToMany(mappedBy="customer",cascade=CascadeType.PERSIST) // customer id will be foreign key
	@JsonIgnoreProperties("customer")
	List<TourPackage> tourPackages; // in TourPackage table
	
	// One customer can make multiple bookings -> (One-to-Many)
	@OneToMany(mappedBy="customer",cascade=CascadeType.PERSIST) // customer id will be foreign key
	@JsonIgnoreProperties("customer")
	ArrayList<Booking> bookings; // in Booking table
	
}
