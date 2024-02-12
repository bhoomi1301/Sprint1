package com.spring.tatms.service;
import java.util.List;

import com.spring.tatms.entity.Customer;
import com.spring.tatms.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO createCustomer(Customer customer);
	List<CustomerDTO> getAllCustomers();
	CustomerDTO getCustomerById(int id);
	CustomerDTO updateCustomer(int id,Customer customer);
	String deleteCustomer(int id); 
	String bookingPackageByCustomer(int cus_id,int tpack_id);
	String bookingMadeByCustomer(int cus_id,int book_id);
}
