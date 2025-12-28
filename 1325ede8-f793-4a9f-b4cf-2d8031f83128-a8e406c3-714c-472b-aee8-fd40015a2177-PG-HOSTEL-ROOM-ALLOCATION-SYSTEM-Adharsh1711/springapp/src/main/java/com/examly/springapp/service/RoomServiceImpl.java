package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Room;
import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomRepository;
import com.examly.springapp.repository.RoomCategoryRepository;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomCategoryRepository roomCategoryRepository;

    public RoomServiceImpl(RoomRepository roomRepository,
            RoomCategoryRepository roomCategoryRepository) {
        this.roomRepository = roomRepository;
        this.roomCategoryRepository = roomCategoryRepository;
    }

    @Override
    public Room addRoom(Room room) {
        Long categoryId = room.getRoomCategory().getRoomCategoryId();

        RoomCategory category = roomCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("RoomCategory not found"));

        room.setRoomCategory(category);
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
}
