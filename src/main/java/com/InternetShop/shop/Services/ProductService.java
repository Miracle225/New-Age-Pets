package com.InternetShop.shop.Services;

import com.InternetShop.shop.Models.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    void save(Product product);
    void edit(UUID id, Product newProduct);
    void delete(UUID id);
    Optional<Product> findById(UUID id);
    List<Product> findAll();
    List<Product> findAllByCategory(UUID Id);
    long count();

}
