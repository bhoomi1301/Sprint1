package com.spring.tatms.model;

import java.util.List;

import com.spring.tatms.entity.TourPackage;

import lombok.Data;

public class HotelDTO {

	private int htl_id;
	private String htl_name;
	private String htl_address;
	private String htl_type;
	private double htl_rent;
	
	List<TourPackage> tourPackages;
	
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
	public HotelDTO(int htl_id, String htl_name, String htl_address, String htl_type, double htl_rent) {
		super();
		this.htl_id = htl_id;
		this.htl_name = htl_name;
		this.htl_address = htl_address;
		this.htl_type = htl_type;
		this.htl_rent = htl_rent;
	}
	
	public HotelDTO(int htl_id, String htl_name, String htl_address, String htl_type, double htl_rent,
			List<TourPackage> tourPackages) {
		super();
		this.htl_id = htl_id;
		this.htl_name = htl_name;
		this.htl_address = htl_address;
		this.htl_type = htl_type;
		this.htl_rent = htl_rent;
		this.tourPackages = tourPackages;
	}
	public HotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
