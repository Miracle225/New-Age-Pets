package com.InternetShop.shop.Services.impl;

import com.InternetShop.shop.Models.Order;
import com.InternetShop.shop.Models.OrderStatus;
import com.InternetShop.shop.Services.OrderService;
import com.InternetShop.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
orderRepository.save(order);
    }

    @Override
    public Order findById(UUID id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findAllByOrderStatusName(OrderStatus status) {
        return orderRepository.findAllByOrderStatus(status);
    }
}
