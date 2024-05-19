package com.example.Hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotelmanagement.dto.PaymentRequest;
import com.example.Hotelmanagement.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin("http://localhost:4200/")
public class PaymentController {

	@Autowired
	PaymentService paymentservice;
	
	@PostMapping("/link")
	public ResponseEntity<String> paymentprocess(@RequestBody PaymentRequest paymentrequest){
		
		boolean status = paymentservice.paymentProcess(paymentrequest.getAmount(),paymentrequest.getCardnumber(),paymentrequest.getCvv(),paymentrequest.getExpiringdate());
		if (status) {
            return ResponseEntity.ok("Payment is successfully done");
        } else {
            return ResponseEntity.badRequest().body("Payment got failed");
        }
	}
	
	
	
}

