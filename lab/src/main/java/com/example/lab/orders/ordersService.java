package com.example.lab.orders;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class ordersService {

    private final ordersRepo ordersRepo;

    public ordersService(ordersRepo repo) {
        this.ordersRepo = repo;
    }

    public List<orders> getAllorders(){
        return ordersRepo.findAll();
    }

    public orders Getorders(String id){
        int Id = Integer.parseInt(id);
        return ordersRepo.findById(Id).orElse(null);
    }

    public orders Addorders(orders p) {
        return ordersRepo.save(p);
    }


}