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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany; 
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int htl_id;
	
	@Column(name = "htl_name", nullable = false)
	private String htl_name;
	
	@Column(name = "htl_address", nullable = false)
	private String htl_address;
	
	@Column(name = "htl_type", nullable = false)
	private String htl_type;
	
	@Column(name = "htl_rent", nullable = false)
	private double htl_rent;
	
	public List<TourPackage> getTourPackages() {
		return tourPackages;
	}

	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
	}

	public int getHtl_id() {
		return htl_id;
	}

	public void setHtl_id(int htl_id) {
		this.htl_id = htl_id;
	}

	public String getHtl_name() {
		return htl_name;
	}

	public void setHtl_name(String htl_name) {
		this.htl_name = htl_name;
	}

	public String getHtl_address() {
		return htl_address;
	}

	public void setHtl_address(String htl_address) {
		this.htl_address = htl_address;
	}

	public String getHtl_type() {
		return htl_type;
	}

	public void setHtl_type(String htl_type) {
		this.htl_type = htl_type;
	}

	public double getHtl_rent() {
		return htl_rent;
	}

	public void setHtl_rent(double htl_rent) {
		this.htl_rent = htl_rent;
	}

	public Hotel(int htl_id, String htl_name, String htl_address, String htl_type, double htl_rent) {
		super();
		this.htl_id = htl_id;
		this.htl_name = htl_name;
		this.htl_address = htl_address;
		this.htl_type = htl_type;
		this.htl_rent = htl_rent;
	}

	public Hotel(int htl_id, String htl_name, String htl_address, String htl_type, double htl_rent,
			List<TourPackage> tourPackages) {
		super();
		this.htl_id = htl_id;
		this.htl_name = htl_name;
		this.htl_address = htl_address;
		this.htl_type = htl_type;
		this.htl_rent = htl_rent;
		this.tourPackages = tourPackages;
	}

	// A hotel can host multiple packages
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="tourPackage_hotel", 
			joinColumns = {@JoinColumn(name="tpack_id") },
			inverseJoinColumns = {@JoinColumn(name="htl_id")} )
	@JsonIgnoreProperties("hotels")
	List<TourPackage> tourPackages;
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
