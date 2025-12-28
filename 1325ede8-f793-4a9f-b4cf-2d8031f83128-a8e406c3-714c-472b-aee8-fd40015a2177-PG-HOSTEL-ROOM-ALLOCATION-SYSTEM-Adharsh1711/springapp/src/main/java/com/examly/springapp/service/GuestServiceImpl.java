package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;

    public GuestServiceImpl(GuestRepository repository) {
        this.repository = repository;
    }

    @Override
    public Guest addGuest(Guest guest) {
        return repository.save(guest);
    }

    @Override
    public List<Guest> getAllGuests() {
        return repository.findAll();
    }

    @Override
    public Guest getGuestById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
