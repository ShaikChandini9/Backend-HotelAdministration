package com.example.Hotelmanagement.service;

import com.example.Hotelmanagement.dto.RoomBookingRequest;
import com.example.Hotelmanagement.model.Room;
import com.example.Hotelmanagement.model.RoomBooking;
import com.example.Hotelmanagement.model.User;
import com.example.Hotelmanagement.repository.BookingRepository;
import com.example.Hotelmanagement.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private RoomRepository roomrepo;
    
    public void roombooking(RoomBookingRequest roomBookingRequest) {
        RoomBooking roomBooking = new RoomBooking();
        roomBooking.setRoomname(roomBookingRequest.getRoomname());
        roomBooking.setNoOfRooms(roomBookingRequest.getNoOfRooms());
        roomBooking.setPrice(roomBookingRequest.getPrice());
        roomBooking.setTimings(roomBookingRequest.getTimings());
        bookingRepository.save(roomBooking);
    }

    public List<RoomBooking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
}
