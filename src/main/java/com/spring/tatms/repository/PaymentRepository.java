package com.spring.tatms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.tatms.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
