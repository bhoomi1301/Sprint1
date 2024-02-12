package com.spring.tatms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tatms.entity.Destination;
import com.spring.tatms.exception.ResourceNotFoundException;
import com.spring.tatms.model.DestinationDTO;
import com.spring.tatms.repository.DestinationRepository;
import com.spring.tatms.service.DestinationService;
import com.spring.tatms.util.Converter;

@Service
public class DestinationServiceImpl implements DestinationService {
	
	@Autowired(required=true)
	private DestinationRepository destinationRepository;
	
	public DestinationServiceImpl(DestinationRepository destinationRepository) {
		super();
		this.destinationRepository = destinationRepository;
	}
	
	@Autowired
	Converter converter;

	@Override
	public DestinationDTO createDestination(Destination destination) {
		Destination des = destinationRepository.save(destination);
		return converter.convertToDestinationDTO(des);
	}

	@Override
	public List<DestinationDTO> getAllDestinations() {
		List<Destination> destinations=destinationRepository.findAll();
		
		//list of type DTO
		List<DestinationDTO> dtoList=new ArrayList<>();
		for(Destination d:destinations)
		{
			dtoList.add(converter.convertToDestinationDTO(d));
		}
		
		return dtoList;
	}

	@Override
	public DestinationDTO getDestinationById(int id) {
		Destination d=destinationRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Destination", "Id", id));
		return converter.convertToDestinationDTO(d);
	}

	@Override
	public DestinationDTO updateDestination(int id, Destination destination) {
		Destination d=destinationRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Destination","Id",id));
		d.setDes_description(destination.getDes_description());
		d.setDes_location(destination.getDes_location());
		
		Destination des=destinationRepository.save(d);
		return converter.convertToDestinationDTO(des);
	}

	@Override
	public String deleteDestination(int id) {
		destinationRepository.deleteById(id);
		return "Destination got deleted successfully!!";
	}

}
