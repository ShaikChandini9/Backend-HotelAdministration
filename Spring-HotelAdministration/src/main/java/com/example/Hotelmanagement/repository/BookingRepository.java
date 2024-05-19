package com.example.Hotelmanagement.repository;

import com.example.Hotelmanagement.model.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<RoomBooking, Long> {
}
