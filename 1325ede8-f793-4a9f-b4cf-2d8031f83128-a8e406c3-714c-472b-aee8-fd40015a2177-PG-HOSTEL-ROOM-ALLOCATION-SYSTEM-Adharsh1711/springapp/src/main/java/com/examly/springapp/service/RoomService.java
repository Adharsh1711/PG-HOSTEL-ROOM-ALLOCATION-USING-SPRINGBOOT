package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Room;

public interface RoomService {
    Room addRoom(Room room);
    List<Room> getAllRooms();
    Room getRoomById(Long id);
}
