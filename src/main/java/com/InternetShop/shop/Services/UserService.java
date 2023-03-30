package com.InternetShop.shop.Services;

import com.InternetShop.shop.Models.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void save(User user);

    void login(String username, String password);

    User findByUserName(String username);

    User findByEmail(String email);

    Optional<User> findById(UUID id);

    User editUser(User user);
    List<User> findAll();

}
