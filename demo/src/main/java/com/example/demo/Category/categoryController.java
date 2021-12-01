package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class categoryController {
    private final categoryService categoryService;
@Autowired
    public categoryController(com.example.demo.Category.categoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category addcategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> getcategory(){
        return categoryService.getcategory();
    }
}
