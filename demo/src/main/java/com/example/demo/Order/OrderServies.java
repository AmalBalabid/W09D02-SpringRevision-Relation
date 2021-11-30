package com.example.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServies {
    private final OrderRepository orderRepository;
@Autowired
    public OrderServies(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order addCategory(Order order) {
    return orderRepository.save(order);
    }
}
