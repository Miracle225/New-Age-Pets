package com.InternetShop.shop.Services;

import com.InternetShop.shop.Models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
    Category findByCategoryName(String category);
    Category findByCategoryId(UUID id);
}
