package com.spring.tatms.service;

import java.util.List;

import com.spring.tatms.entity.Payment;
import com.spring.tatms.model.PaymentDTO;


public interface PaymentService {

	PaymentDTO createPayment(Payment payment);
	List<PaymentDTO> getAllPayments();
	PaymentDTO getPaymentById(int id);
	PaymentDTO updatePayment(int id,Payment payment);
	String deletePayment(int id); 
}
