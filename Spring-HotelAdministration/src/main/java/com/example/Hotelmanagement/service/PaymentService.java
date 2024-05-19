package com.example.Hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotelmanagement.model.Payment;
import com.example.Hotelmanagement.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentrepo;
	
	public boolean paymentProcess(double amount, String cardNumber, String cvv, String expiringdate) {
	
		Payment pay=new Payment();
		
		if (!amountValidation(amount) || !cardValidation(cardNumber) || !cvvalidation(cvv) || !expirationdate(expiringdate)) {
            return false; // Payment failed due to invalid details
        }
		 boolean payment = paymentGateway(amount, cardNumber, cvv, expiringdate);
	        
	        // Log payment status
	        if (payment) {
	        	pay.setAmount(amount);
	        	pay.setCvv(cvv);
	        	pay.setCardnumber(cardNumber);
	        	pay.setExpiringdate(expiringdate);
	        	paymentrepo.save(pay);
	            System.out.println("Payment in dollars $" + amount + " processed successfully.");
	        } else {
	            System.out.println("Payment in dollars $" + amount + " failed.");
	        }
	        
	        return payment;
	}
	
	private boolean amountValidation(double amount) {
		 return amount>0;
	}
	
	private boolean cardValidation(String cardnumber) {
		return cardnumber!=null && cardnumber.matches("\\d{16}");
	}
	
	private boolean cvvalidation(String cvv) {
		return cvv!=null && cvv.matches("\\d{3}");
	}
	
	private boolean expirationdate(String expiringdate) {
		return expiringdate!=null && expiringdate.matches("\\d{2}/\\d{2}");
	}
	
	private boolean paymentGateway(double amount, String cardNumber, String cvv, String expiringdate) {
		
		try {
            // Simulate processing delay
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Return true to simulate successful payment
        return true;
	}
}
