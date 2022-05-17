package com.example.order.repository;

import org.springframework.stereotype.Repository;
import com.example.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    Order findByOrderId(Long orderId);
}
