package com.spring.tatms.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.spring.tatms.entity.Customer;
import com.spring.tatms.entity.Destination;
import com.spring.tatms.entity.Hotel;

public class TourPackageDTO {

	@NotNull 
	private int tpack_id;
	private String tpack_name;
	private Double tpack_price;
	private int tpack_duration;
	private String tpack_details;
	
	private Customer customer;
	private Destination destination;
	
	List<Hotel> hotels;
	
	public List<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getTpack_id() {
		return tpack_id;
	}
	public void setTpack_id(int tpack_id) {
		this.tpack_id = tpack_id;
	}
	public String getTpack_name() {
		return tpack_name;
	}
	public void setTpack_name(String tpack_name) {
		this.tpack_name = tpack_name;
	}
	public Double getTpack_price() {
		return tpack_price;
	}
	public void setTpack_price(Double tpack_price) {
		this.tpack_price = tpack_price;
	}
	public int getTpack_duration() {
		return tpack_duration;
	}
	public void setTpack_duration(int tpack_duration) {
		this.tpack_duration = tpack_duration;
	}
	public String getTpack_details() {
		return tpack_details;
	}
	public void setTpack_details(String tpack_details) {
		this.tpack_details = tpack_details;
	}
	public TourPackageDTO(int tpack_id, String tpack_name, Double tpack_price, int tpack_duration,
			String tpack_details) {
		super();
		this.tpack_id = tpack_id;
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
	}
	
	public TourPackageDTO(int tpack_id, String tpack_name, Double tpack_price, int tpack_duration, String tpack_details,
			Customer customer) {
		super();
		this.tpack_id = tpack_id;
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
		this.customer = customer;
	}
	
	public TourPackageDTO(int tpack_id, String tpack_name, Double tpack_price, int tpack_duration, String tpack_details,
			Destination destination) {
		super();
		this.tpack_id = tpack_id;
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
		this.destination = destination;
	}
	
	public TourPackageDTO(@NotNull int tpack_id, String tpack_name, Double tpack_price, int tpack_duration,
			String tpack_details, List<Hotel> hotels) {
		super();
		this.tpack_id = tpack_id;
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
		this.hotels = hotels;
	}
	public TourPackageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
