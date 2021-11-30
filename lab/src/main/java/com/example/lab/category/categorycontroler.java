package com.example.lab.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "category")
public class categorycontroler {

    private final categoryservice categoryservice;

    @Autowired
    public categorycontroler(categoryservice categoryservice) {
        this.categoryservice = categoryservice;
    }
    @GetMapping
    public List<category> getAllcategory(){
        return categoryservice.getAllcategory();
    }

    @GetMapping("/{id}")
    public category Getcategory(@PathVariable String id ){
        return categoryservice.Getcategory(id);
    }

    @PostMapping
    public category Addcategory(@RequestBody category c){
        return categoryservice.Addcategory(c);
    }


}