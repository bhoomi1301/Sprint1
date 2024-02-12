package com.spring.tatms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tatms.entity.Booking;
import com.spring.tatms.entity.TravelAgent;
import com.spring.tatms.exception.ResourceNotFoundException;
import com.spring.tatms.model.TravelAgentDTO;
import com.spring.tatms.repository.BookingRepository;
import com.spring.tatms.repository.TravelAgentRepository;
import com.spring.tatms.service.TravelAgentService;
import com.spring.tatms.util.Converter;

@Service
public class TravelAgentServiceImpl implements TravelAgentService  {
	
	@Autowired(required=true)
	private TravelAgentRepository travelAgentRepository;
	
	@Autowired(required=true)
	private BookingRepository bookingRepository;
	
	public TravelAgentServiceImpl(TravelAgentRepository travelAgentRepository) {
		super();
		this.travelAgentRepository = travelAgentRepository;
	}
	
	@Autowired
	Converter converter;

	@Override
	public TravelAgentDTO createTravelAgent(TravelAgent travelAgent) {
		TravelAgent tra = travelAgentRepository.save(travelAgent);
		return converter.convertToTravelAgentDTO(tra);
	}

	@Override
	public List<TravelAgentDTO> getAllTravelAgents() {
		List<TravelAgent> travelAgents=travelAgentRepository.findAll();
		
		//list of type DTO
		List<TravelAgentDTO> dtoList=new ArrayList<>();
		for(TravelAgent t:travelAgents)
		{
			dtoList.add(converter.convertToTravelAgentDTO(t));
		}
		
		return dtoList;
	}

	@Override
	public TravelAgentDTO getTravelAgentById(int id) {
		TravelAgent t=travelAgentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("TravelAgent", "Id", id));
		return converter.convertToTravelAgentDTO(t);
	}

	@Override
	public TravelAgentDTO updateTravelAgent(int id, TravelAgent travelAgent) {
		TravelAgent t=travelAgentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("TravelAgent", "Id", id));
		t.setTa_name(travelAgent.getTa_name());
		t.setTa_email(travelAgent.getTa_email());
		
		TravelAgent tra=travelAgentRepository.save(t);
		return converter.convertToTravelAgentDTO(tra);
	}

	@Override
	public String deleteTravelAgent(int id) {
		travelAgentRepository.deleteById(id);
		return "Travel Agent got deleted successfully!!";
	}

	@Override
	public String bookingMadeThroughTravelAgent(int ta_id, int book_id) {
		Booking b=bookingRepository.findById(book_id).orElseThrow(()->
		new ResourceNotFoundException("Booking", "Id", book_id));
		
		TravelAgent  ta=travelAgentRepository.findById(ta_id).orElseThrow(()->
		new ResourceNotFoundException("TravelAgent", "Id", ta_id));
		
		List<Booking> bookings=new ArrayList<>();
		bookings.add(b);
		
		//assign students to teacher
		ta.setBookings(bookings);
		
		//assign teacher to student
		b.setTravelAgent(ta);
		
		travelAgentRepository.save(ta); 
		return "Booking made through Travel Agent successfully";
	}

}
