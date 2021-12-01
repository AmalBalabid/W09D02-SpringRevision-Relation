package com.example.demo.Category;

import com.example.demo.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CService {

    private final Crepo crepo;

    @Autowired
    public CService(Crepo crepo) {
        this.crepo = crepo;
    }

    public List<Category> getCategories(){

        return crepo.findAll();
    }

    public Category postCategory(Category category){
        return crepo.save(category);
    }

    public Category getCategory(String id) {

        Long cId = Long.parseLong(id);
        return crepo.findById(cId).orElse(null);
    }

    public void deleteCategory(String id){
        Long cId = Long.parseLong(id);
        crepo.deleteById(cId);

    }
}
