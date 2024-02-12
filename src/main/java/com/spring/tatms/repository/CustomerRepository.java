package com.spring.tatms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tatms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
