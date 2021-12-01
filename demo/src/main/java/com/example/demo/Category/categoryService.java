package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {
    private final categoryRepository categoryRepository;
@Autowired
    public categoryService(com.example.demo.Category.categoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getcategory() {
        return categoryRepository.findAll();
    }
}
