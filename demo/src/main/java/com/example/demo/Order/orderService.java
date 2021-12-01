package com.example.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    private final orderRepository orderRepository;
    @Autowired

    public orderService(com.example.demo.Order.orderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public order addOrder(order order) {
        return orderRepository.save(order);
    }

    public List<order> getOrders() {
        return orderRepository.findAll();
    }
}
