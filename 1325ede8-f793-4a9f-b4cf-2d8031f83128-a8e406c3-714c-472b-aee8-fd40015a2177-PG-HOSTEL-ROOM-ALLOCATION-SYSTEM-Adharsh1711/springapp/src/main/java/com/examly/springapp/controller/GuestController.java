package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Guest;
import com.examly.springapp.service.GuestService;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Guest> add(@RequestBody Guest guest) {
        return new ResponseEntity<>(service.addGuest(guest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAll() {
        return ResponseEntity.ok(service.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Guest guest = service.getGuestById(id);
        return guest == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guest not found")
                : ResponseEntity.ok(guest);
    }
}
