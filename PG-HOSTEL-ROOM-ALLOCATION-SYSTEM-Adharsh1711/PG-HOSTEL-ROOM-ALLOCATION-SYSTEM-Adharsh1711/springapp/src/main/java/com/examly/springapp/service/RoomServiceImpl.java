package com.examly.springapp.service;

import com.examly.springapp.model.Room;
import com.examly.springapp.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo repo;

    @Override
    public Room save(Room room) {
        return repo.save(room);
    }

    @Override
    public List<Room> findAll() {
        return repo.findAll();
    }

    @Override
    @Nullable
    public Room findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Nullable
    public Room update(Long id, Room room) {
        return repo.findById(id)
                .map(existing -> {
                    room.setRoomId(id);
                    return repo.save(room);
                })
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Room> findByRoomNumber(String roomNumber) {
        return repo.findByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> findByCategoryName(String categoryName) {
        return repo.findByRoomCategory_CategoryName(categoryName);
    }
}
