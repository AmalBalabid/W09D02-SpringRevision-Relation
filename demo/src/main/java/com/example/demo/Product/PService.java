package com.example.demo.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PService {

    private final Prepo prepo;

    @Autowired
    public PService(Prepo prepo) {
        this.prepo = prepo;
    }

    public List<Product> getProducts(){

        return prepo.findAll();
    }

    public Product postProduct(Product product){
        return prepo.save(product);
    }

    public Product getProduct(String id) {

        Long pId = Long.parseLong(id);
        return prepo.findById(pId).orElse(null);
    }

    public void deleteProduct(String id){
        Long pId = Long.parseLong(id);
        prepo.deleteById(pId);

    }
}


