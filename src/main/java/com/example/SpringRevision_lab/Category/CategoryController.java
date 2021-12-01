package com.example.SpringRevision_lab.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
}
