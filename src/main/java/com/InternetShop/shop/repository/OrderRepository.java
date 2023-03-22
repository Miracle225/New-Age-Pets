package com.InternetShop.shop.repository;

import com.InternetShop.shop.Models.Order;
import com.InternetShop.shop.Models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findById(UUID id);
    List<Order> findAllByOrderStatus(OrderStatus status);
}
