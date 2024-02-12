package com.spring.tatms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tatms.entity.Booking;
import com.spring.tatms.entity.Customer;
import com.spring.tatms.entity.TourPackage;
import com.spring.tatms.exception.ResourceNotFoundException;
import com.spring.tatms.model.CustomerDTO;
import com.spring.tatms.repository.BookingRepository;
import com.spring.tatms.repository.CustomerRepository;
import com.spring.tatms.repository.TourPackageRepository;
import com.spring.tatms.service.CustomerService;
import com.spring.tatms.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired(required=true)
	private CustomerRepository customerRepository;
	
	@Autowired
	private TourPackageRepository tourPackageRepository;
	
	@Autowired 
	private BookingRepository bookingRepository;
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Autowired
	Converter converter;
	
	@Override
	public CustomerDTO createCustomer(Customer customer) {
		
		Customer cus = customerRepository.save(customer);
		return converter.convertToCustomerDTO(cus);
	}
	
	@Override
	public List<CustomerDTO> getAllCustomers()
	{
		List<Customer> customers=customerRepository.findAll();
		
		//list of type DTO
		List<CustomerDTO> dtoList=new ArrayList<>();
		for(Customer c:customers)
		{
			dtoList.add(converter.convertToCustomerDTO(c));
		}
		
		return dtoList;
	}

	 @Override
	public CustomerDTO getCustomerById(int id) {
		//Customer c=customerRepository.findById(id).get();
				Customer c=customerRepository.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Customer", "Id", id));
				return converter.convertToCustomerDTO(c);
	}

	@Override
	public CustomerDTO updateCustomer(int id, Customer customer) {
		Customer c=customerRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",id));
		c.setCus_name(customer.getCus_name());
		c.setCus_addr(customer.getCus_addr());
		c.setCus_email(customer.getCus_email());
		c.setCus_password(customer.getCus_password());
		c.setPhno(customer.getPhno());
		
		Customer cus=customerRepository.save(c);
		return converter.convertToCustomerDTO(cus);
	}

	@Override
	public String deleteCustomer(int id) {
		customerRepository.deleteById(id);
		return "Customer got deleted successfully!!";
	}

	@Override
	public String bookingPackageByCustomer(int cus_id, int tpack_id) {
		TourPackage tp = tourPackageRepository.findById(tpack_id).orElseThrow(()->
		new ResourceNotFoundException("TourPackage", "Id",tpack_id));
		
		Customer c=customerRepository.findById(cus_id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",cus_id));
		
		List<TourPackage> tourPackages=new ArrayList<>();
		tourPackages.add(tp);
		
		//assign packages to customer
		c.setTourPackages(tourPackages);
		
		//assign customer to package
		tp.setCustomer(c);
		
		customerRepository.save(c);
		return "Package booked by customer successfully";
		
	}

	@Override
	public String bookingMadeByCustomer(int cus_id, int book_id) {
		Booking b = bookingRepository.findById(book_id).orElseThrow(()->
		new ResourceNotFoundException("Booking", "Id",book_id));
		
		Customer c=customerRepository.findById(cus_id).orElseThrow(()->
		new ResourceNotFoundException("Customer","Id",cus_id));
		
		ArrayList<Booking> bookings= new ArrayList<>();
		bookings.add(b);
		
		//assign bookings to customer
		c.setBookings(bookings);
		
		//assign customer to booking
		b.setCustomer(c);
		
		customerRepository.save(c);
		return "Bookings made by customer successfully"; 
	} 

}
