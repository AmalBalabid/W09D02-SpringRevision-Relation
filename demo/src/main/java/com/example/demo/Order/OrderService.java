package com.example.demo.Order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }


    public Order saveOrders(Order Order){
        return repo.save(Order);
    }

}

