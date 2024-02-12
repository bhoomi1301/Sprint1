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

import com.spring.tatms.entity.Customer;
import com.spring.tatms.service.CustomerService;
import com.spring.tatms.model.CustomerDTO;
import com.spring.tatms.util.Converter;

@RestController 
public class CustomerController {
	
	@Autowired(required=true)
	private CustomerService customerService;
	
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@Autowired
	Converter converter;

	@PostMapping("/api/createCustomer")
	ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
		final Customer customer = converter.convertToCustomerEntity(customerDTO);
		return new ResponseEntity<CustomerDTO>(customerService.createCustomer(customer),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllCustomers")
	List<CustomerDTO> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/api/getCustomerById/{cid}")
	   CustomerDTO getCustomerById(@PathVariable("cid") int id)
	   {
		   return customerService.getCustomerById(id);
	   }
		
	 @PutMapping("/api/updateCustomer/{id}")
	CustomerDTO	updateCustomer(@PathVariable int id,@RequestBody CustomerDTO customerDTO)
	{
			final Customer customer=converter.convertToCustomerEntity(customerDTO);
		return customerService.updateCustomer(id, customer);
	}
	 
	@DeleteMapping("/api/deleteCustomer/{id}")
		String deleteCustomer(@PathVariable int id)
		{
			return customerService.deleteCustomer(id);
		} 
		
	@PostMapping("/api/bookingPackage/{cus_id}/{tpack_id}")
		public String bookingPackageByCustomer(@PathVariable("cus_id") int cus_id,@PathVariable("tpack_id") int tpack_id)
		{
			return customerService.bookingPackageByCustomer(cus_id, tpack_id);
		}
	
	@PostMapping("/api/bookingMade/{cus_id}/{book_id}")
	public String bookingMadeByCustomer(@PathVariable("cus_id") int cus_id,@PathVariable("book_id") int book_id)
	{
		return customerService.bookingMadeByCustomer(cus_id, book_id);
	}
}
