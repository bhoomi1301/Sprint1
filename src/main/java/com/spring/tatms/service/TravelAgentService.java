package com.spring.tatms.service;

import java.util.List;

import com.spring.tatms.entity.TravelAgent;
import com.spring.tatms.model.TravelAgentDTO;


public interface TravelAgentService {
	
	TravelAgentDTO createTravelAgent(TravelAgent travelAgent);
	List<TravelAgentDTO> getAllTravelAgents();
	TravelAgentDTO getTravelAgentById(int id);
	TravelAgentDTO updateTravelAgent(int id,TravelAgent travelAgent);
	String deleteTravelAgent(int id); 
	String bookingMadeThroughTravelAgent(int ta_id,int book_id); 
}
