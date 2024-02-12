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

import com.spring.tatms.entity.TravelAgent;
import com.spring.tatms.model.TravelAgentDTO;
import com.spring.tatms.service.TravelAgentService;
import com.spring.tatms.util.Converter;

@RestController
public class TravelAgentController {

	@Autowired(required=true)
	private TravelAgentService travelAgentService;

	public TravelAgentController(TravelAgentService travelAgentService) {
		super();
		this.travelAgentService = travelAgentService;
	}
	
	@Autowired
	Converter converter;
	
	@PostMapping("/api/createTravelAgent")
	ResponseEntity<TravelAgentDTO> createTravelAgent(@RequestBody TravelAgentDTO travelAgentDTO) {
		final TravelAgent travelAgent = converter.convertToTravelAgentEntity(travelAgentDTO);
		return new ResponseEntity<TravelAgentDTO>(travelAgentService.createTravelAgent(travelAgent),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllTravelAgents")
	List<TravelAgentDTO> getAllTravelAgents()
	{
		return travelAgentService.getAllTravelAgents();
	}
	
	@GetMapping("/api/getTravelAgentById/{tid}")
	TravelAgentDTO getTravelAgentById(@PathVariable("tid") int id)
	   {
		   return travelAgentService.getTravelAgentById(id);
	   }
	
	@PutMapping("/api/updateTravelAgent/{id}")
	TravelAgentDTO	updateTravelAgent(@PathVariable int id,@RequestBody TravelAgentDTO travelAgentDTO)
	{
			final TravelAgent travelAgent=converter.convertToTravelAgentEntity(travelAgentDTO);
		return travelAgentService.updateTravelAgent(id, travelAgent);
	}
	
	@DeleteMapping("/api/deleteTravelAgent/{id}")
	String deleteTravelAgent(@PathVariable int id)
	{
		return travelAgentService.deleteTravelAgent(id);
	} 
	
	@PostMapping("/api/bookingMadeThroughTA/{ta_id}/{book_id}")
	public String bookingMadeThroughTravelAgent(@PathVariable("ta_id") int ta_id,
			@PathVariable("book_id") int book_id)
	{
		return travelAgentService.bookingMadeThroughTravelAgent(ta_id, book_id);
	}
}
