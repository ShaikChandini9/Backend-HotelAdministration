package com.example.Hotelmanagement.controller;

import com.example.Hotelmanagement.dto.RoomDto;
import com.example.Hotelmanagement.model.Room;
import com.example.Hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@CrossOrigin("http://localhost:4200/")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity addRoom(@RequestBody RoomDto roomDto){
        roomService.addRoom(roomDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Room>> gelAllRooms() {
        return new ResponseEntity<>(roomService.getAllRooms(),HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return new ResponseEntity<>(roomService.getRoomById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody RoomDto roomdto) {
        roomService.update(roomdto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        roomService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
