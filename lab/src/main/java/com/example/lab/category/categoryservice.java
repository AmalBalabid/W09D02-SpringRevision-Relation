package com.example.lab.category;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class categoryservice {

    private final categoryrepo repo;

    public categoryservice(categoryrepo repo) {
        this.repo = repo;
    }

    public List<category> getAllcategory(){
        return repo.findAll();
    }

    public category Getcategory(String id){
        int Id = Integer.parseInt(id);
        return repo.findById(Id).orElse(null);
    }

    public category Addcategory(category p) {
        return repo.save(p);
    }


}