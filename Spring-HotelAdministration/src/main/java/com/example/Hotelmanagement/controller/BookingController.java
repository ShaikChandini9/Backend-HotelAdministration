package com.example.Hotelmanagement.controller;

import com.example.Hotelmanagement.dto.RoomBookingRequest;
import com.example.Hotelmanagement.model.RoomBooking;
import com.example.Hotelmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(
        origins = {"http://localhost:4200/"},
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT}
)
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/ticket-booking")
    public ResponseEntity roombooking(@RequestBody RoomBookingRequest roomBookingRequest){
        bookingService.roombooking(roomBookingRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<RoomBooking> getAllOrders() {
        return bookingService.getAllBookings();
    }
}
