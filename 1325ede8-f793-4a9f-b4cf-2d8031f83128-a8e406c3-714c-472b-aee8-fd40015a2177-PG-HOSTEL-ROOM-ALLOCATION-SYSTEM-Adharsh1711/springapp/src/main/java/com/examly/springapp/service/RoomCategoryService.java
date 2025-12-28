package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.RoomCategory;

public interface RoomCategoryService {
    RoomCategory addRoomCategory(RoomCategory category);
    List<RoomCategory> getAllRoomCategories();
}
