package com.example.Hotelmanagement.service;

import com.example.Hotelmanagement.dto.RoomDto;
import com.example.Hotelmanagement.model.Room;
import com.example.Hotelmanagement.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    @InjectMocks
    RoomService roomService;

    @Mock
    RoomRepository roomRepository;

    RoomDto roomDto=new RoomDto();
    Room room=new Room();
    List<Room> roomList=new ArrayList<>();

    @BeforeEach

    public void room(){

        roomDto.setId(123L);
        roomDto.setRoomname("suite");
        roomDto.setRoomtype("deluxe");
        roomDto.setImg("img");
        roomDto.setPrice(100);

    }
    @Test
    public void addRoomTest(){
        Mockito.lenient().when(roomRepository.save(room)).thenReturn(room);
        roomService.addRoom(roomDto);
    }

    @Test
    public void getAllRoomsTest(){
        roomList.add(room);
        when(roomRepository.findAll()).thenReturn(roomList);
        List<Room> actual=roomService.getAllRooms();
        assertNotNull(actual);
    }

    @Test
    public void getRoomByIdTest(){

        doNothing().when(roomRepository).findById(12L);
        Room actual=roomService.getRoomById(12L);
        assertNotNull(actual);
    }
}
