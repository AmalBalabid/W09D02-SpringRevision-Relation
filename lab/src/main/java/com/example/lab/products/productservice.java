package com.example.lab.products;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class productservice {
    private final productrepo repo;

    public productservice(com.example.lab.products.productrepo repo) {
        this.repo = repo;
    }

    public ResponseEntity<String> Responseproduct(String id, String name){
        return ResponseEntity.ok().body(id+" "+name);
    }

    public product GetProduct(String id){
        int Id = Integer.parseInt(id);
        return repo.findById(Id).orElse(null);
    }

    public product AddProduct(product p) {
        return repo.save(p);
    }

    @ResponseBody
    public ResponseEntity<String> DeleteProduct(String id){
        int Id = Integer.parseInt(id);
        repo.deleteById(Id);
        return ResponseEntity.ok().body("deleted");
    }

    public product UpdateProduct(String id, product p) {
        int Id = Integer.parseInt(id);
        product result = repo.findById(Id).orElse(null);
        if (result != null){
            result.setName(p.getName());
            repo.save(result);
        }
        return result;
    }

}