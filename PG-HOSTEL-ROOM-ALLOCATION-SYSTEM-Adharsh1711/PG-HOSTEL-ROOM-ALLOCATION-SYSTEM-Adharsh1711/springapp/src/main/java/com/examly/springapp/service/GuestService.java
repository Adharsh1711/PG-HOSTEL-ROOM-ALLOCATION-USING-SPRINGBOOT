package com.examly.springapp.service;

import com.examly.springapp.model.Guest;
import java.util.List;

public interface GuestService {

    Guest save(Guest guest);

    List<Guest> findAll();

    Guest findById(Long id);   // ❗ NOT Optional

    Guest update(Long id, Guest guest);

    void delete(Long id);

    List<Guest> findByPhone(String phone);

    List<Guest> findByEmail(String email);
}
