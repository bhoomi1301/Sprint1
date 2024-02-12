package com.spring.tatms.service;

import java.util.List;

import com.spring.tatms.entity.TourPackage;
import com.spring.tatms.model.TourPackageDTO;

public interface TourPackageService {

	TourPackageDTO createTourPackage(TourPackage tourPackage);
	List<TourPackageDTO> getAllTourPackages();
	TourPackageDTO getTourPackageById(int id);
	TourPackageDTO updateTourPackage(int id,TourPackage tourPackage);
	String deleteTourPackage(int id); 
	String assignDestinationToPackage(int tpack_id,int des_id);
	String packageStaysAtHotel(int tpack_id,int htl_id); 
}
