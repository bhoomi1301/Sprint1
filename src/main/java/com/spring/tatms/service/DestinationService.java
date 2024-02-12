package com.spring.tatms.service;

import java.util.List;

import com.spring.tatms.entity.Destination;
import com.spring.tatms.model.DestinationDTO;


public interface DestinationService {

	DestinationDTO createDestination(Destination destination);
	List<DestinationDTO> getAllDestinations();
	DestinationDTO getDestinationById(int id);
	DestinationDTO updateDestination(int id,Destination destination);
	String deleteDestination(int id); 
}
