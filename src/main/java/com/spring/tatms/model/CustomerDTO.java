package com.spring.tatms.model;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.spring.tatms.entity.Booking;
import com.spring.tatms.entity.TourPackage;

public class CustomerDTO {

	@NotNull
	private int cus_id;
	
	@NotNull
	@Size(min=2,max=50,message="Name should contain min 2 to max 50 characters")
	private String cus_name;
	
	@Size(min=5,max=100,message="Name should contain min 5 to max 100 characters")
	private String cus_addr;
	private String cus_email;
	private String cus_password;
	private String phno;
	
	List<TourPackage> tourPackages;
	ArrayList<Booking> bookings;
	
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<TourPackage> getTourPackages() {
		return tourPackages;
	}
	
	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
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
	public CustomerDTO(int cus_id, String cus_name, String cus_addr, String cus_email, String cus_password,
			String phno) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.cus_password = cus_password;
		this.phno = phno;
	}
	
	public CustomerDTO(int cus_id, String cus_name, String cus_addr, String cus_email, String cus_password, String phno,
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

	public CustomerDTO(@NotNull int cus_id,
			@NotNull @Size(min = 2, max = 50, message = "Name should contain min 2 to max 50 characters") String cus_name,
			@Size(min = 5, max = 100, message = "Name should contain min 5 to max 100 characters") String cus_addr,
			String cus_email, String cus_password, String phno, ArrayList<Booking> bookings) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_addr = cus_addr;
		this.cus_email = cus_email;
		this.cus_password = cus_password;
		this.phno = phno;
		this.bookings = bookings;
	}

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
