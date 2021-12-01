package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class productService {
    private final productRepository productRepository;


    @Autowired
    public productService(com.example.demo.Product.productRepository productRepository) {
        this.productRepository = productRepository;
    }



    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getProduct(){
        return productRepository.findAll();
    }
}
