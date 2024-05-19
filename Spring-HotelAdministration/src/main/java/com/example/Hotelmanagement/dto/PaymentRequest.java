package com.example.Hotelmanagement.dto;

public class PaymentRequest {

	private double amount;
	private String cardnumber;
	private String cvv;
	private String expiringdate;
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
