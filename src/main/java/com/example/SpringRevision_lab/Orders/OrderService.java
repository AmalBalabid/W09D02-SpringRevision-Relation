package com.example.SpringRevision_lab.Orders;

import com.example.SpringRevision_lab.Product.Product;
import com.example.SpringRevision_lab.Product.ProductRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepo orderRepo, ProductRepository productRepository) {
        this.orderRepo = orderRepo;
        this.productRepository = productRepository;
    }

    public List<Orders> getOrders(){
        return orderRepo.findAll();
    }

    public Orders getOrder(String id){
        Long order_id = Long.parseLong(id);
        return orderRepo.findById(order_id).orElse(null);
    }

    public Orders createOrder(Orders orders, Long product_id){
        Product product = productRepository.findById(product_id).orElse(null);
        orders.getProducts().add(product);
        return orderRepo.save(orders);
    }
}
