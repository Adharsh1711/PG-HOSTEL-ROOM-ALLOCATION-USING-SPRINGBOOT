package com.examly.springapp.controller;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.service.RoomCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room-categories")
public class RoomCategoryController {

    @Autowired
    private RoomCategoryService service;

    // ✅ CREATE ROOM CATEGORY
    @PostMapping
    public ResponseEntity<?> create(@RequestBody(required = false) RoomCategory category) {
        if (category == null) {
            return ResponseEntity.badRequest().build(); // Day6 BadRequest test
        }
        return new ResponseEntity<>(service.save(category), HttpStatus.CREATED);
    }

    // ✅ GET ALL ROOM CATEGORIES
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<RoomCategory> list = service.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build(); // Day6 NoContent test
        }
        return ResponseEntity.ok(list);
    }

    // ✅ GET CATEGORY BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RoomCategory category = service.findById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room category not found");
        }
        return ResponseEntity.ok(category);
    }

    // ✅ UPDATE CATEGORY
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody RoomCategory category) {
        RoomCategory updated = service.update(id, category);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updated);
    }

    // ✅ DELETE CATEGORY
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    // ✅ PAGINATION (DAY 9 – ALL TESTS)
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<RoomCategory>> getPaginated(
            @PathVariable int page,
            @PathVariable int size) {
                
        Page<RoomCategory> result = service.getPaginated(page, size);
        return ResponseEntity.ok(result);
    }
}


     