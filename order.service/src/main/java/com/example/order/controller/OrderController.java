package com.example.order.controller;

import com.example.order.entity.Order;
import com.example.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {


    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order) {
        log.info("Inside saveOrder method of OrderController");
        return  orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable("id") Long orderId) {
        log.info("Inside findOrderById method of OrderController");
        return orderService.findOrderById(orderId);
    }

}