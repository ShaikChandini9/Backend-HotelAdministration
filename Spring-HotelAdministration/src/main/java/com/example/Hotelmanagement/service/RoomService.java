package com.example.Hotelmanagement.service;

import com.example.Hotelmanagement.dto.RoomDto;
import com.example.Hotelmanagement.model.Room;
import com.example.Hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private AuthService authService;

    @Autowired
    private RoomRepository roomRepository;


    public void addRoom(RoomDto roomDto) {
        Room room = new Room();
        room.setImg(roomDto.getImg());
        room.setRoomname(roomDto.getRoomname());
        room.setRoomtype(roomDto.getRoomtype());
        room.setPrice(roomDto.getPrice());
        roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).get();
    }
    //delete

    public void update(RoomDto roomDto) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setImg(roomDto.getImg());
        room.setRoomname(roomDto.getRoomname());
        room.setRoomtype(roomDto.getRoomtype());
        roomRepository.save(room);

    }
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}
