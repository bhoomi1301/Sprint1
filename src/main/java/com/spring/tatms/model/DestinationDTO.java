package com.spring.tatms.model;

import javax.validation.constraints.NotNull;

import com.spring.tatms.entity.TourPackage;

public class DestinationDTO {

	@NotNull 
	private int des_id;
	private String des_description;
	private String des_location;
	
	private TourPackage tourPackage;
	
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
	public DestinationDTO(int des_id, String des_description, String des_location) {
		super();
		this.des_id = des_id;
		this.des_description = des_description;
		this.des_location = des_location;
	}
	
	public DestinationDTO(int des_id, String des_description, String des_location, TourPackage tourPackage) {
		super();
		this.des_id = des_id;
		this.des_description = des_description;
		this.des_location = des_location;
		this.tourPackage = tourPackage;
	}
	
	public DestinationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
