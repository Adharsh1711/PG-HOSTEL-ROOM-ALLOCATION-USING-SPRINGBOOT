package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepository;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    private final RoomCategoryRepository repository;

    public RoomCategoryServiceImpl(RoomCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoomCategory addRoomCategory(RoomCategory category) {
        return repository.save(category);
    }

    @Override
    public List<RoomCategory> getAllRoomCategories() {
        return repository.findAll();
    }
}
