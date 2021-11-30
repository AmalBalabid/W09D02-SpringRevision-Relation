package com.example.lab.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "orders")
public class ordersControler {

    private final ordersService ordersService;

    @Autowired
    public ordersControler(ordersService ordersService) {
        this.ordersService = ordersService;
    }
    @GetMapping
    public List<orders> getAllcategory(){
        return ordersService.getAllorders();
    }

    @GetMapping("/{id}")
    public orders Getorders(@PathVariable String id ){
        return ordersService.Getorders(id);
    }

    @PostMapping
    public orders Addorders(@RequestBody orders c){
        return ordersService.Addorders(c);
    }


}