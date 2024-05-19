package com.example.Hotelmanagement.controller;

import com.example.Hotelmanagement.dto.RoomDto;
import com.example.Hotelmanagement.model.Room;
import com.example.Hotelmanagement.service.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoomControllerTest {

    @InjectMocks
    RoomController roomController;

    @Mock
    RoomService roomService;

    RoomDto roomDto=new RoomDto();

    List<Room> roomList=new ArrayList<>();

    @Test
    public void addRoomTest(){
        roomDto.setId(123L);
        roomDto.setRoomname("suite");
        roomDto.setRoomtype("deluxe");
        roomDto.setImg("img");
        roomDto.setPrice(100);
        doNothing().when(roomService).addRoom(roomDto);
        ResponseEntity responseEntity=roomController.addRoom(roomDto);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @Test
    public void getAllRoomsTest(){

        when(roomService.getAllRooms()).thenReturn(roomList);
        ResponseEntity<List<Room>> responseEntity=roomController.gelAllRooms();
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }
}
