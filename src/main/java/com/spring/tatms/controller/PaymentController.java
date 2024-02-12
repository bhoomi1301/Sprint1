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

import com.spring.tatms.entity.Payment;
import com.spring.tatms.model.PaymentDTO;
import com.spring.tatms.service.PaymentService;
import com.spring.tatms.util.Converter;

@RestController
public class PaymentController {

	@Autowired(required=true)
	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	@Autowired
	Converter converter;
	
	@PostMapping("/api/createPayment")
	ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
		final Payment payment = converter.convertToPaymentEntity(paymentDTO);
		return new ResponseEntity<PaymentDTO>(paymentService.createPayment(payment),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllPayments")
	List<PaymentDTO> getAllPayments()
	{
		return paymentService.getAllPayments();
	}
	
	@GetMapping("/api/getPaymentById/{pid}")
	PaymentDTO getPaymentById(@PathVariable("pid") int id)
	   {
		   return paymentService.getPaymentById(id);
	   }
	
	@PutMapping("/api/updatePayment/{id}")
	PaymentDTO	updatePayment(@PathVariable int id,@RequestBody PaymentDTO paymentDTO)
		{
			final Payment payment=converter.convertToPaymentEntity(paymentDTO);
			return paymentService.updatePayment(id, payment);
		}
	
	@DeleteMapping("/api/deletePayment/{id}")
	String deletePayment(@PathVariable int id)
	{
		return paymentService.deletePayment(id);
	} 
	
}
