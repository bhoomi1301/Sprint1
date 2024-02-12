package com.spring.tatms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tatms.entity.Payment;
import com.spring.tatms.exception.ResourceNotFoundException;
import com.spring.tatms.model.PaymentDTO;
import com.spring.tatms.repository.PaymentRepository;
import com.spring.tatms.service.PaymentService;
import com.spring.tatms.util.Converter;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired(required=true)
	private PaymentRepository paymentRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}
	
	@Autowired
	Converter converter;

	@Override
	public PaymentDTO createPayment(Payment payment) {
		Payment pay = paymentRepository.save(payment);
		return converter.convertToPaymentDTO(pay);
	}

	@Override
	public List<PaymentDTO> getAllPayments() {
		List<Payment> payments=paymentRepository.findAll();
		
		//list of type DTO
		List<PaymentDTO> dtoList=new ArrayList<>();
		for(Payment p:payments)
		{
			dtoList.add(converter.convertToPaymentDTO(p));
		}
		
		return dtoList;
	}

	@Override
	public PaymentDTO getPaymentById(int id) {
		Payment p=paymentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Payment", "Id", id));
		return converter.convertToPaymentDTO(p);
	}

	@Override
	public PaymentDTO updatePayment(int id, Payment payment) {
		Payment p=paymentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Payment", "Id", id));
		p.setPay_amt(payment.getPay_amt());
		p.setPay_date(payment.getPay_date());
		p.setPay_status(payment.getPay_status());
		
		Payment pay=paymentRepository.save(p);
		return converter.convertToPaymentDTO(pay);
	}

	@Override
	public String deletePayment(int id) {
		paymentRepository.deleteById(id);
		return "Payment got deleted successfully!!";
	}

}
