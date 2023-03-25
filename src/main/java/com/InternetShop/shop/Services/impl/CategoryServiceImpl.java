package com.InternetShop.shop.Services.impl;

import com.InternetShop.shop.Models.Category;
import com.InternetShop.shop.Services.CategoryService;
import com.InternetShop.shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findByCategoryName(String category) {
        return categoryRepository.findByCategoryName(category);
    }

    @Override
    public Category findByCategoryId(UUID id) {
        return categoryRepository.findById(id).get();
    }
}
