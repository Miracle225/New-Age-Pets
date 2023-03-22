package com.InternetShop.shop.Services;

import com.InternetShop.shop.Models.Order;
import com.InternetShop.shop.Models.OrderStatus;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    void save(Order order);
    Order findById(UUID id);
    List<Order> findAll();
    List<Order> findAllByOrderStatusName(OrderStatus status);

}
