package com.example.lab.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "product")
public class productcontroler {

    private final productservice service;

    @Autowired
    public productcontroler(productservice productservice) {
        this.service = productservice;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> Responseproduct(@RequestParam String id, @RequestParam String name) {
        return service.Responseproduct(id,name);
    }

    @GetMapping("/{id}")
    public product GetProduct(@PathVariable String id ){
        return service.GetProduct(id);
    }

    @PostMapping
    public product addProduct(@RequestBody product p){
        return service.AddProduct(p);
    }

    @PutMapping("/{id}")
    public product Updateproduct(@PathVariable String id , @RequestBody product p){
        return service.UpdateProduct(id,p);
    }

    @DeleteMapping ("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteproduct(@PathVariable String id) {
        return service.DeleteProduct(id);
    }


}