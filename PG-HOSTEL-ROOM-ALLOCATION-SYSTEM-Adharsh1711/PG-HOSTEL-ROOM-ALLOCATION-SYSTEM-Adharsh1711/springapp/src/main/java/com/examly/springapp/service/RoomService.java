package com.examly.springapp.service;

import com.examly.springapp.model.Room;
import java.util.List;

public interface RoomService {

    Room save(Room room);

    List<Room> findAll();

    Room findById(Long id);   // ❗ NOT Optional

    Room update(Long id, Room room);

    void delete(Long id);

    List<Room> findByRoomNumber(String roomNumber);

    List<Room> findByCategoryName(String categoryName);
}
