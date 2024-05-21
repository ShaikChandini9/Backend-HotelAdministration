package com.example.Hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotelmanagement.dto.InventoryRequest;
import com.example.Hotelmanagement.model.Inventory;
import com.example.Hotelmanagement.service.InventoryService;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin("http://localhost:4200/")
public class InventoryController {

	@Autowired
	InventoryService stockservice;
	
	@PostMapping("/stock")
	public ResponseEntity stock(@RequestBody InventoryRequest stockrequest) {
	
		stockservice.addingstock(stockrequest);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Inventory> getallitems(){
		return stockservice.findallitems();
	}
	
	@PostMapping("/add/addstockquantity")
	public ResponseEntity<String> addingStockQuantity(String itemname,@RequestParam int quantity) {
		stockservice.addingstockqunantity(itemname, quantity);
		return ResponseEntity.ok("Added sucessfully");
	}

	@GetMapping("/remaining/{stockId}")
    public ResponseEntity getRemainingStockCount(@PathVariable Long stockId) {
        stockservice.getStockCount(stockId);
        return ResponseEntity.ok("updated sucessfully");
    }

	@PostMapping("/usaged/stock/count")
    public ResponseEntity<String> updateStock(@RequestBody InventoryRequest request) {
        stockservice.updateStock(request);
        return ResponseEntity.ok("Stock updated based on usage successfully");
    }

	@GetMapping("/{stockId}/reorder-message")
    public ResponseEntity<String> getReorderMessage(@PathVariable Long stockId) {
        String reorderMessage = stockservice.getReorderMessage(stockId);
        return ResponseEntity.ok(reorderMessage);
    }
    
}
