package com.spring.tatms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tatms.entity.Destination;
import com.spring.tatms.entity.Hotel;
import com.spring.tatms.entity.TourPackage;
import com.spring.tatms.exception.ResourceNotFoundException;
import com.spring.tatms.model.TourPackageDTO;
import com.spring.tatms.repository.DestinationRepository;
import com.spring.tatms.repository.HotelRepository;
import com.spring.tatms.repository.TourPackageRepository;
import com.spring.tatms.service.TourPackageService;
import com.spring.tatms.util.Converter;

@Service
public class TourPackageServiceImpl implements TourPackageService {
	
	@Autowired(required=true)
	private TourPackageRepository tourPackageRepository;
	
	@Autowired(required=true)
	private DestinationRepository destinationRepository;
	
	@Autowired(required=true)
	private HotelRepository hotelRepository;
	
	public TourPackageServiceImpl(TourPackageRepository tourPackageRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
	}
	
	@Autowired
	Converter converter;

	@Override
	public TourPackageDTO createTourPackage(TourPackage tourPackage) {
		TourPackage tpack = tourPackageRepository.save(tourPackage);
		return converter.convertToTourPackageDTO(tpack);
	}

	@Override
	public List<TourPackageDTO> getAllTourPackages() {
		List<TourPackage> tourPackages=tourPackageRepository.findAll();
		
		//list of type DTO
		List<TourPackageDTO> dtoList=new ArrayList<>();
		for(TourPackage tp:tourPackages)
		{
			dtoList.add(converter.convertToTourPackageDTO(tp));
		}
		
		return dtoList;
	}

	@Override
	public TourPackageDTO getTourPackageById(int id) {
		TourPackage tp=tourPackageRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("TourPackage", "Id", id));
		return converter.convertToTourPackageDTO(tp);
	}

	@Override
	public TourPackageDTO updateTourPackage(int id, TourPackage tourPackage) {
		TourPackage tp=tourPackageRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("TourPackage", "Id", id));
		tp.setTpack_name(tourPackage.getTpack_name());
		tp.setTpack_price(tourPackage.getTpack_price());
		tp.setTpack_duration(tourPackage.getTpack_duration());
		tp.setTpack_details(tourPackage.getTpack_details());
		
		TourPackage tpack=tourPackageRepository.save(tp);
		return converter.convertToTourPackageDTO(tpack); 
	}

	@Override
	public String deleteTourPackage(int id) {
		tourPackageRepository.deleteById(id);
		return "Tour Package got deleted successfully!!";
	}

	@Override
	public String assignDestinationToPackage(int tpack_id, int des_id) {
		Destination d=destinationRepository.findById(des_id).orElseThrow(()->
		new ResourceNotFoundException("Destination", "Id", des_id));
		
		TourPackage  tp=tourPackageRepository.findById(tpack_id).orElseThrow(()->
		new ResourceNotFoundException("TourPackage", "Id", tpack_id));
		
		//assign destination to package
		tp.setDestination(d); 
		
		//assign package to destination
		d.setTourPackage(tp);
		
		tourPackageRepository.save(tp);
		return "Destination assigned to Package successfully";
	}

	@Override
	public String packageStaysAtHotel(int tpack_id, int htl_id) {
		Hotel h=hotelRepository.findById(htl_id).orElseThrow(()->
		new ResourceNotFoundException("Hotel", "Id", htl_id));  
		
		TourPackage t=tourPackageRepository.findById(tpack_id).orElseThrow(()->
		new ResourceNotFoundException("TourPackage", "Id", tpack_id)); 
		
		List<Hotel> hotels=new ArrayList<>();
		hotels.add(h);
		
		List<TourPackage> tourPackages=new ArrayList<>(); 
		tourPackages.add(t); 
		
		//setting hotels to packages
		t.setHotels(hotels);
		
		//setting packages to hotels 
		h.setTourPackages(tourPackages);
		
		tourPackageRepository.save(t); 
		return "Hotel assigned to Tour Package successfully"; 
	}

}
