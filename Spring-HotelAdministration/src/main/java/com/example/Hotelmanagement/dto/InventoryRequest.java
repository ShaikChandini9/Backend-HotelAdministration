package com.example.Hotelmanagement.dto;

public class InventoryRequest {

	private Long stockid;
	private String itemname;
	private int quantity;
	public Long getStockid() {
		return stockid;
	}
	public void setStockid(Long stockid) {
		this.stockid = stockid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private int usedquantity;
	public int getUsedquantity() {
		return usedquantity;
	}
	public void setUsedquantity(int usedquantity) {
		this.usedquantity = usedquantity;
	}
	
	
	
}
