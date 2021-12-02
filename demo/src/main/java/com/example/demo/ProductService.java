package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private final ProductRepo productRebo;

    @Autowired
    public ProductService(ProductRepo productRebo) {
        this.productRebo = productRebo;
    }

//    public Product GetProduct(String id) {
//    }
//
//    public void updateProduct(String id) {
//    }

    public ResponseEntity<String> Responseproduct(String id, String name){
        return ResponseEntity.ok().body(id+" "+name);
    }

    public Product getProduct(String id){
        Long Id = Long.parseLong(id);
        return productRebo.findById(Id).orElse(null);
    }

    public Product AddProduct(Product product){
        return productRebo.save(product);

    }
    public ResponseEntity<String> deleteProduct(String id){
        Long Id = Long.parseLong(id);
        productRebo.deleteById(Id);
        return ResponseEntity.ok().body("deleted");

    }
    public Product updateProduct(Product product) {

        Long Id = product.getId();

        Product result = productRebo.findById(Id).orElse(null);
        if (result != null){
            result.setName(product.getName());
            result.setPrice(product.getPrice());
            productRebo.save(result);
        }
        return result;
    }



}





