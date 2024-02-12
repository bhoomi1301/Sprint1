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

import com.spring.tatms.entity.Booking;
import com.spring.tatms.model.BookingDTO;
import com.spring.tatms.service.BookingService;
import com.spring.tatms.util.Converter;

@RestController
public class BookingController {
	
	@Autowired(required=true)
	private BookingService bookingService;

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	
	@Autowired
	Converter converter;
	
	@PostMapping("/api/createBooking")
	ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
		final Booking booking = converter.convertToBookingEntity(bookingDTO);
		return new ResponseEntity<BookingDTO>(bookingService.createBooking(booking),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllBookings")
	List<BookingDTO> getAllBookings()
	{
		return bookingService.getAllBookings();
	}
	
	@GetMapping("/api/getBookingById/{bid}")
	   BookingDTO getBookingById(@PathVariable("bid") int id)
	   {
		   return bookingService.getBookingById(id);
	   }
	
	@PutMapping("/api/updateBooking/{id}")
	BookingDTO	updateBooking(@PathVariable int id,@RequestBody BookingDTO bookingDTO)
	{
			final Booking booking=converter.convertToBookingEntity(bookingDTO);
		return bookingService.updateBooking(id, booking);
	}
	
	@DeleteMapping("/api/deleteBooking/{id}")
	String deleteBooking(@PathVariable int id)
	{
		return bookingService.deleteBooking(id);
	} 
	
	@PostMapping("/api/bookingPayment/{book_id}/{pay_id}")
	public String bookingPaysForPayment(@PathVariable("book_id") int book_id,
			@PathVariable("pay_id") int pay_id)
	{
		return bookingService.bookingPaysForPayment(book_id, pay_id); 
	}

}
