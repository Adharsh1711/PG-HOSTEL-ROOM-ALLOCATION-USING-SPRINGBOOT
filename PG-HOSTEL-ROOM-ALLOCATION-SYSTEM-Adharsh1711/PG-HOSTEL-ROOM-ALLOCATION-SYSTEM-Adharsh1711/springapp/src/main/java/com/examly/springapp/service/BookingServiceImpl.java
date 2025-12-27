package com.examly.springapp.service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.repository.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;

    public BookingServiceImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking addBooking(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Booking cannot be null");
        }
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return bookingRepo.findById(id);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        if (id == null || booking == null) {
            throw new IllegalArgumentException("Id or Booking cannot be null");
        }

        Optional<Booking> optionalBooking = bookingRepo.findById(id);
        if (optionalBooking.isEmpty()) {
            throw new RuntimeException("Booking not found");
        }

        Booking existing = optionalBooking.get();
        existing.setCheckInDate(booking.getCheckInDate());
        existing.setCheckOutDate(booking.getCheckOutDate());
        existing.setTotalAmount(booking.getTotalAmount());
        existing.setGuest(booking.getGuest());
        existing.setRoom(booking.getRoom());

        return bookingRepo.save(existing);
    }

    @Override
    public void deleteBooking(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        bookingRepo.deleteById(id);
    }
}
