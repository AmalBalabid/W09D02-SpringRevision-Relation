package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")

public class productController {
private final productService productService;
   @Autowired
    public productController(com.example.demo.Product.productService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){

        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product>getProduct(){
       return productService.getProduct();
    }

}
