package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="products")
public class Controller {

    private final PService service;

    @Autowired
    public Controller(PService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts(){
        return  service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return  service.getProduct(id);
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product){
        return service.postProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        service.deleteProduct(id);

    }

}
