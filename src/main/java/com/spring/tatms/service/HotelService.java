package com.spring.tatms.service;

import java.util.List;

import com.spring.tatms.entity.Hotel;
import com.spring.tatms.model.HotelDTO;


public interface HotelService {

	HotelDTO createHotel(Hotel hotel);
	List<HotelDTO> getAllHotels();
	HotelDTO getHotelById(int id);
	HotelDTO updateHotel(int id,Hotel hotel);
	String deleteHotel(int id); 
}
