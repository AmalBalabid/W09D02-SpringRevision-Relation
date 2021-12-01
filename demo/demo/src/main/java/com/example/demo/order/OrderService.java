package com.example.demo.order;
import com.example.demo.categroy.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
 public List<Order>getOrders(){
        return orderRepository.findAll();
 }
    public Order getOrder(String id){
        Long order_id = Long.parseLong(id);
        return orderRepository.findById(order_id).orElse(null);
    }
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }


    public void deleteOrder(String id){
        Long order_id = Long.parseLong(id);
        orderRepository.deleteById(order_id);

    }


}
