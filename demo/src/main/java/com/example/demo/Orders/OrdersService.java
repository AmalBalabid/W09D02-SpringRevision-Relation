package com.example.demo.Orders;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders saveOrders(Orders orders){
        return ordersRepository.save(orders);
    }

}
