package com.example.demo.Order;

import com.example.demo.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OService {

    private final ORepo oRepo;

    @Autowired
    public OService(ORepo oRepo) {
        this.oRepo = oRepo;
    }

    public List<Order> getOrders(){
        return oRepo.findAll();
    }

    public Order postOrder(Order order){
        return oRepo.save(order);
    }

    public Order getOrder(String id) {

        Long oId = Long.parseLong(id);
        return oRepo.findById(oId).orElse(null);
    }

    public void deleteOrder(String id){
        Long oId = Long.parseLong(id);
        oRepo.deleteById(oId);

    }
}
