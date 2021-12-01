package com.example.demo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class orderController {
    private final orderService orderService;

    @Autowired

    public orderController(com.example.demo.Order.orderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public order addUser(@RequestBody order order){
        return orderService.addOrder(order);
    }

    @GetMapping
    public List<order> getOrders(){
        return orderService.getOrders();
    }
}
