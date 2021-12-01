package com.example.demo.categroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="categories")

public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();

    }


    @GetMapping("/{id}")
    public Category getCategory(@PathVariable String id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id){
        categoryService.deleteCategory(id);
    }
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable String id, @RequestBody Category data){
        categoryService.updateCategory(id, data);
    }
}
