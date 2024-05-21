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
public class Inventory {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long stockid;
	private String itemname;
	private int previouscount;
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

	public int getPreviouscount() {
		return previouscount;
	}

	public void setPreviouscount(int previouscount) {
		this.previouscount = previouscount;
	}

	private int usedquantity;
	public int getUsedquantity() {
		return usedquantity;
	}
	public void setUsedquantity(int usedquantity) {
		this.usedquantity = usedquantity;
	}
	
	private int totalquantity;
	public int getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(int totalquantity) {
		this.totalquantity = totalquantity;
	}
	
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int updatequantity;

	public int getUpdatequantity() {
		return updatequantity;
	}

	public void setUpdatequantity(int updatequantity) {
		this.updatequantity = updatequantity;
	}
}
