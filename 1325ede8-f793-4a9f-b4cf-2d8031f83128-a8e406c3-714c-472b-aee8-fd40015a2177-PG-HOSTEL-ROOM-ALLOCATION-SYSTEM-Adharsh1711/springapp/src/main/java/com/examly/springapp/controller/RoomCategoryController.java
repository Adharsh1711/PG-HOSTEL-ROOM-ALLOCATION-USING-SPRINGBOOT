package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.service.RoomCategoryService;

@RestController
@RequestMapping("/api/room-categories")
public class RoomCategoryController {

    private final RoomCategoryService service;

    public RoomCategoryController(RoomCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RoomCategory> add(@RequestBody RoomCategory category) {
        return new ResponseEntity<>(service.addRoomCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoomCategory>> getAll() {
        return ResponseEntity.ok(service.getAllRoomCategories());
    }
}
