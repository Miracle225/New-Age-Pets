package com.InternetShop.shop.Services;

import com.InternetShop.shop.Models.Category;

import java.util.List;

public interface CategoryService {
    void save(Category category);
    List<Category> findAll();
}
