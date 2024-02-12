package com.spring.tatms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.spring.tatms.entity.Booking;
import com.spring.tatms.entity.Customer;
import com.spring.tatms.entity.Destination;
import com.spring.tatms.entity.Hotel;
import com.spring.tatms.entity.Payment;
import com.spring.tatms.entity.TourPackage;
import com.spring.tatms.entity.TravelAgent;

import com.spring.tatms.model.BookingDTO;
import com.spring.tatms.model.CustomerDTO;
import com.spring.tatms.model.DestinationDTO;
import com.spring.tatms.model.HotelDTO;
import com.spring.tatms.model.PaymentDTO;
import com.spring.tatms.model.TourPackageDTO;
import com.spring.tatms.model.TravelAgentDTO;


@Component
public class Converter {
	
	// convert from DTO to entity
	public Customer convertToCustomerEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		if(customerDTO!=null) {
			BeanUtils.copyProperties(customerDTO, customer);
		}
		return customer;
	}
	
	// convert from entity to DTO
	public CustomerDTO convertToCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO();
		if(customer!=null) {
			BeanUtils.copyProperties(customer, customerDTO);
		}
		return customerDTO;
	}
	
	// convert from DTO to entity
		public Booking convertToBookingEntity(BookingDTO bookingDTO) {
			Booking booking = new Booking();
			if(bookingDTO!=null) {
				BeanUtils.copyProperties(bookingDTO, booking);
			}
			return booking;
		}
		
		// convert from entity to DTO
		public BookingDTO convertToBookingDTO(Booking booking) {
			BookingDTO bookingDTO = new BookingDTO();
			if(booking!=null) {
				BeanUtils.copyProperties(booking, bookingDTO);
			}
			return bookingDTO;
		}
	
		// convert from DTO to entity
		public Destination convertToDestinationEntity(DestinationDTO destinationDTO) {
			Destination destination = new Destination();
			if(destinationDTO!=null) {
				BeanUtils.copyProperties(destinationDTO, destination);
			}
			return destination;
		}
		
		// convert from entity to DTO
		public DestinationDTO convertToDestinationDTO(Destination destination) {
			DestinationDTO destinationDTO = new DestinationDTO();
			if(destination!=null) {
				BeanUtils.copyProperties(destination, destinationDTO);
			}
			return destinationDTO;
		}

		// convert from DTO to entity
		public Hotel convertToHotelEntity(HotelDTO hotelDTO) {
			Hotel hotel = new Hotel();
			if(hotelDTO!=null) {
				BeanUtils.copyProperties(hotelDTO, hotel);
			}
			return hotel;
		}
		
		// convert from entity to DTO
		public HotelDTO convertToHotelDTO(Hotel hotel) {
			HotelDTO hotelDTO = new HotelDTO();
			if(hotel!=null) {
				BeanUtils.copyProperties(hotel, hotelDTO);
			}
			return hotelDTO;
		}
		
		// convert from DTO to entity
		public Payment convertToPaymentEntity(PaymentDTO paymentDTO) {
			Payment payment = new Payment();
			if(paymentDTO!=null) {
				BeanUtils.copyProperties(paymentDTO, payment);
			}
			return payment;
		}
		
		// convert from entity to DTO
		public PaymentDTO convertToPaymentDTO(Payment payment) {
			PaymentDTO paymentDTO = new PaymentDTO();
			if(payment!=null) {
				BeanUtils.copyProperties(payment, paymentDTO);
			}
			return paymentDTO;
		}
		
		// convert from DTO to entity
		public TravelAgent convertToTravelAgentEntity(TravelAgentDTO travelAgentDTO) {
			TravelAgent travelAgent = new TravelAgent();
			if(travelAgentDTO!=null) {
				BeanUtils.copyProperties(travelAgentDTO, travelAgent);
			}
			return travelAgent;
		}
		
		// convert from entity to DTO
		public TravelAgentDTO convertToTravelAgentDTO(TravelAgent travelAgent) {
			TravelAgentDTO travelAgentDTO = new TravelAgentDTO();
			if(travelAgent!=null) {
				BeanUtils.copyProperties(travelAgent, travelAgentDTO);
			}
			return travelAgentDTO;
		}
		
		// convert from DTO to entity
		public TourPackage convertToTourPackageEntity(TourPackageDTO tourPackageDTO) {
			TourPackage tourPackage = new TourPackage();
			if(tourPackageDTO!=null) {
				BeanUtils.copyProperties(tourPackageDTO, tourPackage);
			}
			return tourPackage;
		}
		
		// convert from entity to DTO
		public TourPackageDTO convertToTourPackageDTO(TourPackage tourPackage) {
			TourPackageDTO tourPackageDTO = new TourPackageDTO();
			if(tourPackage!=null) {
				BeanUtils.copyProperties(tourPackage, tourPackageDTO);
			}
			return tourPackageDTO;
		}

		
}
