package com.examly.springapp.service;

import com.examly.springapp.model.RoomCategory;
import com.examly.springapp.repository.RoomCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomCategoryServiceImpl implements RoomCategoryService {

    @Autowired
    private RoomCategoryRepo repo;

    @Override
    public RoomCategory save(RoomCategory category) {
        return repo.save(category);
    }

    @Override
    public List<RoomCategory> findAll() {
        return repo.findAll();
    }

    @Override
    @Nullable
    public RoomCategory findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Nullable
    public RoomCategory update(Long id, RoomCategory category) {
        return repo.findById(id)
                .map(existing -> {
                    category.setCategoryId(id);
                    return repo.save(category);
                })
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Page<RoomCategory> getPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("categoryId"));
        return repo.findAll(pageable);
    }
}
