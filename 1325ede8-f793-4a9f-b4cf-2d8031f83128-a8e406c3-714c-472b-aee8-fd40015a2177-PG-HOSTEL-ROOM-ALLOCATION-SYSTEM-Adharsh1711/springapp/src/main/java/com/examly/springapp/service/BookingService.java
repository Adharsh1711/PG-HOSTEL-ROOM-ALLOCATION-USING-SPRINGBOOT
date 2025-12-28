package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Booking;

public interface BookingService {
    Booking addBooking(Booking booking);
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(Long id);
}
