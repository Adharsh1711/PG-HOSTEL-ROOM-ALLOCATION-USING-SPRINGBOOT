package com.examly.springapp.service;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepo repo;

    @Override
    public Guest save(Guest guest) {
        return repo.save(guest);
    }

    @Override
    public List<Guest> findAll() {
        return repo.findAll();
    }

    @Override
    @Nullable
    public Guest findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Nullable
    public Guest update(Long id, Guest guest) {
        return repo.findById(id)
                .map(existing -> {
                    guest.setGuestId(id);
                    return repo.save(guest);
                })
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Guest> findByPhone(String phone) {
        return repo.findByPhone(phone);
    }

    @Override
    public List<Guest> findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
