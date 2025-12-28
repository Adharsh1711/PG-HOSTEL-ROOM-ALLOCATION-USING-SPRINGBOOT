package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Room;
import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.BookingRepository;
import com.examly.springapp.repository.RoomRepository;
import com.examly.springapp.repository.GuestRepository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              RoomRepository roomRepository,
                              GuestRepository guestRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public Booking addBooking(Booking booking) {

        Room room = roomRepository.findById(
                booking.getRoom().getRoomId()
        ).orElseThrow(() -> new RuntimeException("Room not found"));

        Guest guest = guestRepository.findById(
                booking.getGuest().getGuestId()
        ).orElseThrow(() -> new RuntimeException("Guest not found"));

        booking.setRoom(room);
        booking.setGuest(guest);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        return bookingRepository.findById(id).map(existing -> {

            Room room = roomRepository.findById(
                    booking.getRoom().getRoomId()
            ).orElseThrow(() -> new RuntimeException("Room not found"));

            Guest guest = guestRepository.findById(
                    booking.getGuest().getGuestId()
            ).orElseThrow(() -> new RuntimeException("Guest not found"));

            existing.setRoom(room);
            existing.setGuest(guest);
            existing.setCheckInDate(booking.getCheckInDate());
            existing.setCheckOutDate(booking.getCheckOutDate());

            return bookingRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
