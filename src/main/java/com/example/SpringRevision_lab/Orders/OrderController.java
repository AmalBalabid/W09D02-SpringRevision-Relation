package com.example.SpringRevision_lab.Orders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping
    public Orders createOrder(@RequestBody Form form){
        return orderService.createOrder(form.getOrders(),form.getProduct_id());
    }
}

class Form{
    private Orders orders;
    private Long product_id;

    public Orders getOrders(){return orders;}
    public Long getProduct_id(){return product_id;}
}