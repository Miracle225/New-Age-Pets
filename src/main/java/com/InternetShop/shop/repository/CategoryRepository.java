package com.InternetShop.shop.repository;

import com.InternetShop.shop.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByCategoryName(String name);
}
