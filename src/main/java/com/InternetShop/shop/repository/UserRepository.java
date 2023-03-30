package com.InternetShop.shop.repository;

import com.InternetShop.shop.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findById(UUID id);
    User findByEmail(String email);
    User findByUsername(String username);
    List<User> findAll();
}
