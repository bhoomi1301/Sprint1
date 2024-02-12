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

import com.spring.tatms.entity.TourPackage;
import com.spring.tatms.model.TourPackageDTO;
import com.spring.tatms.service.TourPackageService;
import com.spring.tatms.util.Converter;

@RestController
public class TourPackageController {

	@Autowired(required=true)
	private TourPackageService tourPackageService;

	public TourPackageController(TourPackageService tourPackageService) {
		super();
		this.tourPackageService = tourPackageService;
	}
	
	@Autowired
	Converter converter;
	
	@PostMapping("/api/createTourPackage")
	ResponseEntity<TourPackageDTO> createTourPackage(@RequestBody TourPackageDTO tourPackageDTO) {
		final TourPackage tourPackage = converter.convertToTourPackageEntity(tourPackageDTO);
		return new ResponseEntity<TourPackageDTO>(tourPackageService.createTourPackage(tourPackage),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllTourPackages")
	List<TourPackageDTO> getAllTourPackages()
	{
		return tourPackageService.getAllTourPackages();
	}
	
	@GetMapping("/api/getTourPackageById/{tpid}")
	TourPackageDTO getTourPackageById(@PathVariable("tpid") int id)
	   {
		   return tourPackageService.getTourPackageById(id);
	   }
	
	 @PutMapping("/api/updateTourPackage/{id}")
	 TourPackageDTO	updateTourPackage(@PathVariable int id,@RequestBody TourPackageDTO tourPackageDTO)
		{
			final TourPackage tourPackage=converter.convertToTourPackageEntity(tourPackageDTO);
			return tourPackageService.updateTourPackage(id, tourPackage);
		}
	 
	 @DeleteMapping("/api/deleteTourPackage/{id}")
		String deleteTourPackage(@PathVariable int id)
		{
			return tourPackageService.deleteTourPackage(id);
		} 
	 
	 @PostMapping("/api/assignment/{tpack_id}/{des_id}")
		public String assignDestinationToPackage(@PathVariable("tpack_id") int tpack_id,
				@PathVariable("des_id") int des_id)
		{
			return tourPackageService.assignDestinationToPackage(tpack_id, des_id);
		}
	 

	@PostMapping("/api/assignment/{tpack_id}/{htl_id}")
		public String packageStaysAtHotel(@PathVariable("tpack_id") int tpack_id, 
				@PathVariable("htl_id") int htl_id)
		{
			return tourPackageService.packageStaysAtHotel(tpack_id, htl_id); 
		}
}
