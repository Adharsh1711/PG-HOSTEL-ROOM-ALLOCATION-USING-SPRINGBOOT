package com.examly.springapp.service;

import com.examly.springapp.model.RoomCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoomCategoryService {

    RoomCategory save(RoomCategory category);

    List<RoomCategory> findAll();

    RoomCategory findById(Long id);

    RoomCategory update(Long id, RoomCategory category);

    void delete(Long id);

    // ✅ REQUIRED FOR DAY 9
    Page<RoomCategory> getPaginated(int page, int size);
}
