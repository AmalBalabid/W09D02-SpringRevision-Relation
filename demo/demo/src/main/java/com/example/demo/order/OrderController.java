package com.example.demo.order;
import com.example.demo.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="orders")
@CrossOrigin("*")

public class OrderController {
    private final OrderService orderService;
@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();

    }


    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id){
        return orderService.getOrder(id);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id){
        orderService.deleteOrder(id);
    }
}
