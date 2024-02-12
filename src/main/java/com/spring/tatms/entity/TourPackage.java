package com.spring.tatms.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany; 
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tour_package")
public class TourPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tpack_id;
	
	@Column(name = "tpack_name", nullable = false)
	private String tpack_name;
	
	@Column(name = "tpack_price", nullable = false)
	private Double tpack_price;
	
	@Column(name = "tpack_duration", nullable = false)
	private int tpack_duration;
	
	@Column(name = "tpack_details", nullable = false)
	private String tpack_details;
	
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

	public TourPackage(int tpack_id, String tpack_name, Double tpack_price, int tpack_duration, String tpack_details,
			Customer customer) {
		super();
		this.tpack_id = tpack_id;
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
		this.customer = customer;
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

	public TourPackage(int tpack_id, String tpack_name, Double tpack_price, int tpack_duration, String tpack_details) {
		super();
		this.tpack_id = tpack_id;
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
	}
	
	public TourPackage(int tpack_id, String tpack_name, Double tpack_price, int tpack_duration, String tpack_details,
			Destination destination) {
		super();
		this.tpack_id = tpack_id;
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
		this.destination = destination;
	}

	public TourPackage(int tpack_id, String tpack_name, Double tpack_price, int tpack_duration, String tpack_details,
			List<Hotel> hotels) {
		super();
		this.tpack_id = tpack_id; 
		this.tpack_name = tpack_name;
		this.tpack_price = tpack_price;
		this.tpack_duration = tpack_duration;
		this.tpack_details = tpack_details;
		this.hotels = hotels;
	}

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cus_id")
	@JsonIgnoreProperties("tourPackages")
	private Customer customer;        //Multiple packages can be booked by single customer -> (Many-to-One)
	
	// A package can have only one destination -> (One-to-One)
	@OneToOne(mappedBy="tourPackage",cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties("tourPackage")
	private Destination destination;
	
	// A package can contain multiple hotels
	@ManyToMany(mappedBy="tourPackages",cascade=CascadeType.PERSIST)
	@JsonIgnoreProperties("tourPackages")
	List<Hotel> hotels; 

	public TourPackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
