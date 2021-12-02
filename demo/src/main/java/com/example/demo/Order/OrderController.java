package com.example.demo.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "orders")
public class OrderController {

    private OrderService services;

    public OrderController(OrderService services) {
        this.services = services;
    }

    @PostMapping
    public Order addOrder(@RequestBody Order Order) {
        return services.saveOrders(Order);
    }

}