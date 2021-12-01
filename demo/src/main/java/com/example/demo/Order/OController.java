package com.example.demo.Order;


import com.example.demo.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "orders")
public class OController {

    private final OService oService;

    @Autowired
    public OController(OService oService) {
        this.oService = oService;
    }

    @GetMapping
    public List<Order> getOrders(){
        return  oService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id){
        return  oService.getOrder(id);
    }

    @PostMapping
    public Order postOrder(@RequestBody Order order){
        return oService.postOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        oService.deleteOrder(id);

    }
}
