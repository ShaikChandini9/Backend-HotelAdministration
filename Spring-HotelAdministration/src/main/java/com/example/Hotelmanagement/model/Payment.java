package com.example.Hotelmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long paymentid;
	private double amount;
	private String cardnumber;
	private String cvv;
	private String expiringdate;
	
	
	public Long getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(Long paymentid) {
		this.paymentid = paymentid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiringdate() {
		return expiringdate;
	}
	public void setExpiringdate(String expiringdate) {
		this.expiringdate = expiringdate;
	}
	
}
