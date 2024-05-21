package com.example.Hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hotelmanagement.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	 Inventory findBystockid(Long id);
	 Inventory findByItemname(String itemname);
}
