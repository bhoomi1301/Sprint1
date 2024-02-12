package com.spring.tatms.service;

import java.util.List;

import com.spring.tatms.entity.Booking;

import com.spring.tatms.model.BookingDTO;

public interface BookingService {

	BookingDTO createBooking(Booking booking);
	List<BookingDTO> getAllBookings();
	BookingDTO getBookingById(int id);
	BookingDTO updateBooking(int id,Booking booking);
	String deleteBooking(int id); 
	String bookingPaysForPayment(int book_id,int pay_id);
}
