package com.example.order.service;

import com.example.order.repository.OrderRepository;
import com.example.order.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService{

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        log.info("Inside saveOrder of orderService");
        return orderRepository.save(order);
    }

    public Order findOrderById(Long orderId) {
        log.info("Inside saveOrder of OrderService");
        return orderRepository.findByOrderId(orderId);
    }

}