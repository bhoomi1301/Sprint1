package com.spring.tatms.entity;

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
@Table(name = "destination")
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int des_id;
	
	@Column(name = "des_descr", nullable = false)
	private String des_description;
	
	@Column(name = "des_loc", nullable = false)
	private String des_location;

	public TourPackage getTourPackage() {
		return tourPackage;
	}

	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}

	public int getDes_id() {
		return des_id;
	}

	public void setDes_id(int des_id) {
		this.des_id = des_id;
	}

	public String getDes_description() {
		return des_description;
	}

	public void setDes_description(String des_description) {
		this.des_description = des_description;
	}

	public String getDes_location() {
		return des_location;
	}

	public void setDes_location(String des_location) {
		this.des_location = des_location;
	}

	public Destination(int des_id, String des_description, String des_location) {
		super();
		this.des_id = des_id;
		this.des_description = des_description;
		this.des_location = des_location;
	}

	public Destination(int des_id, String des_description, String des_location, TourPackage tourPackage) {
		super();
		this.des_id = des_id;
		this.des_description = des_description;
		this.des_location = des_location;
		this.tourPackage = tourPackage;
	}
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="tpack_id")
	@JsonIgnoreProperties("destination")
	private TourPackage tourPackage; // A destination can be associated with only one package

	public Destination() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
