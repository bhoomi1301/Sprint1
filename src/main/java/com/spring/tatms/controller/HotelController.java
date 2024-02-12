package com.spring.tatms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.tatms.entity.Hotel;
import com.spring.tatms.model.HotelDTO;
import com.spring.tatms.service.HotelService;
import com.spring.tatms.util.Converter;



@RestController
public class HotelController {
	
	@Autowired(required=true)
	private HotelService hotelService;

	public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}
	
	@Autowired
	Converter converter;
	
	@PostMapping("/api/createHotel")
	ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
		final Hotel hotel = converter.convertToHotelEntity(hotelDTO);
		return new ResponseEntity<HotelDTO>(hotelService.createHotel(hotel),HttpStatus.CREATED);
	}

	@GetMapping("/api/getAllHotels")
	List<HotelDTO> getAllHotels()
	{
		return hotelService.getAllHotels();
	}
	
	@GetMapping("/api/getHotelById/{hid}")
	   HotelDTO getHotelById(@PathVariable("hid") int id)
	   {
		   return hotelService.getHotelById(id);
	   }
	
	@PutMapping("/api/updateHotel/{id}")
	HotelDTO updateHotel(@PathVariable int id,@RequestBody HotelDTO hotelDTO)
	{
			final Hotel hotel=converter.convertToHotelEntity(hotelDTO);
		return hotelService.updateHotel(id, hotel);
	}
	
	@DeleteMapping("/api/deleteHotel/{id}")
	String deleteHotel(@PathVariable int id)
	{
		return hotelService.deleteHotel(id);
	} 
}
