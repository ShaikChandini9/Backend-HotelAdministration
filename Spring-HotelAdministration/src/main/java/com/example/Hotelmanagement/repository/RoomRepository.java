package com.example.Hotelmanagement.repository;

import com.example.Hotelmanagement.model.Room;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
}
