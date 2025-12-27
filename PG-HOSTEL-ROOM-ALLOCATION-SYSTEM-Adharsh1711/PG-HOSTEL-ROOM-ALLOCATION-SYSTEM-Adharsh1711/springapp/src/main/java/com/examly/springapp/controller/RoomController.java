package com.examly.springapp.controller;

import com.examly.springapp.model.Room;
import com.examly.springapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room room) {
        return new ResponseEntity<>(service.save(room), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Room room = service.findById(id); // ✅ FIX
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Room room) {
        Room updated = service.update(id, room);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/number/{roomNumber}")
    public ResponseEntity<?> getByRoomNumber(@PathVariable String roomNumber) {
        List<Room> rooms = service.findByRoomNumber(roomNumber);
        if (rooms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No room found with number: " + roomNumber);
        }
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Room>> getByCategoryName(@PathVariable String categoryName) {
        return ResponseEntity.ok(service.findByCategoryName(categoryName));
    }
}
