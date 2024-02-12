package com.spring.tatms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tatms.entity.Hotel;
import com.spring.tatms.exception.ResourceNotFoundException;
import com.spring.tatms.model.HotelDTO;
import com.spring.tatms.repository.HotelRepository;
import com.spring.tatms.service.HotelService;
import com.spring.tatms.util.Converter;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired(required=true)
	private HotelRepository hotelRepository;
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}
	
	@Autowired
	Converter converter;

	@Override
	public HotelDTO createHotel(Hotel hotel) {
		Hotel hot = hotelRepository.save(hotel);
		return converter.convertToHotelDTO(hot);
	}

	@Override
	public List<HotelDTO> getAllHotels() {
		List<Hotel> hotels=hotelRepository.findAll();
		
		//list of type DTO
		List<HotelDTO> dtoList=new ArrayList<>();
		for(Hotel h:hotels)
		{
			dtoList.add(converter.convertToHotelDTO(h));
		}
		
		return dtoList;
	}

	@Override
	public HotelDTO getHotelById(int id) {
		Hotel h=hotelRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Hotel", "Id", id));
		return converter.convertToHotelDTO(h);
	}

	@Override
	public HotelDTO updateHotel(int id, Hotel hotel) {
		Hotel h=hotelRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Hotel", "Id", id));
		h.setHtl_name(hotel.getHtl_name());
		h.setHtl_address(hotel.getHtl_address());
		h.setHtl_type(hotel.getHtl_type());
		h.setHtl_rent(hotel.getHtl_rent());
		
		Hotel hot=hotelRepository.save(h);
		return converter.convertToHotelDTO(hot);
	}

	@Override
	public String deleteHotel(int id) {
		hotelRepository.deleteById(id);
		return "Hotel got deleted successfully!!";
	}

}
