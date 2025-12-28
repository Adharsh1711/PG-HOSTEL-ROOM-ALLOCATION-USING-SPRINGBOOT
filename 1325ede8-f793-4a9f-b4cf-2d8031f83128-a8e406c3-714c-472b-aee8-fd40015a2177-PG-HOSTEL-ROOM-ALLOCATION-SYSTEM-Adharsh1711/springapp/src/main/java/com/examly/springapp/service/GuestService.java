package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Guest;

public interface GuestService {
    Guest addGuest(Guest guest);
    List<Guest> getAllGuests();
    Guest getGuestById(Long id);
}
