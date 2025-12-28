package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Booking;
import com.examly.springapp.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Booking booking) {
        try {
            return new ResponseEntity<>(service.addBooking(booking), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAll() {
        return ResponseEntity.ok(service.getAllBookings());
    }

   @GetMapping("/{id}")
public ResponseEntity<Booking> getById(@PathVariable Long id) {
    return service.getBookingById(id)
            .map(booking -> ResponseEntity.ok(booking))
            .orElseGet(() -> ResponseEntity.notFound().build());
}


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Booking booking) {
        try {
            return ResponseEntity.ok(service.updateBooking(id, booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
