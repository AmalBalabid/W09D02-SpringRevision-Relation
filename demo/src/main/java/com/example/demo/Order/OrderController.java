package com.example.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="orders")
public class OrderController {
    private final OrderServies orderServies;

@Autowired
    public OrderController(OrderServies orderServies) {
        this.orderServies = orderServies;
    }
    @GetMapping
    public List<Order> getOrders(){
        return orderServies.getOrders();
    }
    @PostMapping
    public Order addCategory(@RequestBody Order order){
        return orderServies .addCategory(order);
    }
}
