package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Category")
@CrossOrigin("*")
public class CategoryController {

    private final CategoryService services;

    @Autowired
    public CategoryController(CategoryService services) {
        this.services = services;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return services.addCategory(category);
    }

    @GetMapping
    public Category getCategory(@PathVariable String id){
        return services.getCategory(id);
    }
}
