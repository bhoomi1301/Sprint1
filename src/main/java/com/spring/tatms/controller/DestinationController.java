package com.spring.tatms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.tatms.entity.Destination;
import com.spring.tatms.model.DestinationDTO;
import com.spring.tatms.service.DestinationService;
import com.spring.tatms.util.Converter;

@RestController
public class DestinationController {
	
	@Autowired(required=true)
	private DestinationService destinationService;

	public DestinationController(DestinationService destinationService) {
		super();
		this.destinationService = destinationService;
	}
	
	@Autowired
	Converter converter;
	
	@PostMapping("/api/createDestination")
	ResponseEntity<DestinationDTO> createDestination(@RequestBody DestinationDTO destinationDTO) {
		final Destination destination = converter.convertToDestinationEntity(destinationDTO);
		return new ResponseEntity<DestinationDTO>(destinationService.createDestination(destination),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllDestinations")
	List<DestinationDTO> getAllDestinations()
	{
		return destinationService.getAllDestinations();
	}
	
	@GetMapping("/api/getDestinationById/{did}")
	DestinationDTO getDestinationById(@PathVariable("did") int id)
	   {
		   return destinationService.getDestinationById(id);
	   }
	
	@PutMapping("/api/updateDestination/{id}")
	DestinationDTO	updateDestination(@PathVariable int id,@RequestBody DestinationDTO destinationDTO)
	{
			final Destination destination=converter.convertToDestinationEntity(destinationDTO);
		return destinationService.updateDestination(id, destination);
	}

}
