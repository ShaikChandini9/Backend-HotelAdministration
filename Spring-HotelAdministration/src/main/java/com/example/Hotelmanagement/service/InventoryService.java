package com.example.Hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotelmanagement.dto.InventoryRequest;
import com.example.Hotelmanagement.model.Inventory;
import com.example.Hotelmanagement.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository stockrepository;
	
	public void stock(InventoryRequest stockrequest) {
		
		Inventory stock=new Inventory();
		stock.setStockid(stockrequest.getStockid());
		stock.setItemname(stockrequest.getItemname());
		stock.setQuantity(stockrequest.getQuantity());
		stockrepository.save(stock);
	}
	
	public List<Inventory> findallitems(){
		return stockrepository.findAll();
	}
	
	public void addstock(String itemname,int quantity) {
		
		Inventory inventory=stockrepository.findByItemname(itemname);
		int currentquantity=inventory.getQuantity();
		int updatecount=currentquantity+quantity;
		inventory.setQuantity(updatecount);
		stockrepository.save(inventory);
	}
	
//	 public void updateStock(InventoryRequest stockRequest) {
//		    Long stockId = stockRequest.getStockid();
//	        Integer usedQuantity = stockRequest.getUsedquantity();
//	        Inventory stock = stockrepository.findBystockid(stockId);
//	        if (stock != null) {
//	            stock.setUsedquantity(usedQuantity);
//	            stockrepository.save(stock);
//	        } else {
//	            throw new IllegalArgumentException("Stock not found with id: " + stockId);
//	        }
//	    }
//	 
//	 	public void getStockCount(Long stockId) {
//	        Inventory stock = stockrepository.findById(stockId)
//	                .orElseThrow(() -> new IllegalArgumentException("Stock not found with id: " + stockId));
//
//	        int Quantity = stock.getQuantity();
//	        int usedQuantity = stock.getUsedquantity();
//	        int totalQuantity=Quantity - usedQuantity;
//	        stock.setTotalquantity(totalQuantity);
//	        stockrepository.save(stock);
//	    }
	 
//	 public String getReorderMessage(Long stockId) {
//		 
//		    final int neededcount= 70; 
//		    final String message = "Stock reorder needed for item ID %d. Current stock level is %d.";
//
//	        Inventory stock = stockrepository.findById(stockId)
//	                .orElseThrow(() -> new IllegalArgumentException("Stock not found with id: " + stockId));
//
//	        int remainingcount=stock.getTotalquantity();
//
//	        if (remainingcount <= neededcount) {
//	        	stock.setMessage("re-order");
//	        	stockrepository.save(stock);
//	            return String.format(message, stockId, remainingcount);
//	        } else {
//	        	stock.setMessage("enough stock");
//	        	stockrepository.save(stock);
//	            return "No reorder needed for this item.";
//	        }
//	    }

}