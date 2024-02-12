package com.spring.tatms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tatms.entity.Booking;
import com.spring.tatms.entity.Payment;
import com.spring.tatms.exception.ResourceNotFoundException;
import com.spring.tatms.model.BookingDTO;
import com.spring.tatms.repository.BookingRepository;
import com.spring.tatms.repository.PaymentRepository;
import com.spring.tatms.service.BookingService;
import com.spring.tatms.util.Converter;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired(required=true)
	private BookingRepository bookingRepository;
	
	@Autowired(required=true)
	private PaymentRepository paymentRepository;
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}

	@Autowired
	Converter converter;

	@Override
	public BookingDTO createBooking(Booking booking) {
		Booking book = bookingRepository.save(booking);
		return converter.convertToBookingDTO(book);
	}

	@Override
	public List<BookingDTO> getAllBookings() {
		List<Booking> bookings=bookingRepository.findAll();
		
		//list of type DTO
		List<BookingDTO> dtoList=new ArrayList<>();
		for(Booking b:bookings)
		{
			dtoList.add(converter.convertToBookingDTO(b));
		}
		
		return dtoList;
	}

	@Override
	public BookingDTO getBookingById(int id) {
		Booking b=bookingRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Booking", "Id", id));
		return converter.convertToBookingDTO(b);
	}

	@Override
	public BookingDTO updateBooking(int id, Booking booking) {
		Booking b=bookingRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Booking","Id",id));
		b.setBook_status(booking.isBook_status());
		b.setBook_time(booking.getBook_time());
		b.setBook_date(booking.getBook_date());
		
		Booking book=bookingRepository.save(b);
		return converter.convertToBookingDTO(book);
	}

	@Override
	public String deleteBooking(int id) {
		bookingRepository.deleteById(id);
		return "Booking got deleted successfully!!";
	}

	@Override
	public String bookingPaysForPayment(int book_id, int pay_id) { 
		Payment p=paymentRepository.findById(pay_id).orElseThrow(()->
		new ResourceNotFoundException("Payment", "Id", pay_id));
		
		Booking  b=bookingRepository.findById(book_id).orElseThrow(()->
		new ResourceNotFoundException("Booking", "Id", book_id));
		
		//setting payment to booking
		b.setPayment(p);
		
		//setting booking to payment
		p.setBooking(b);
		
		bookingRepository.save(b);
		return "Payment has done to your booking successfully"; 
	}

}
