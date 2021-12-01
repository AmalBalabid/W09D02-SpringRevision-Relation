package com.example.demo.categroy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository productRepository) {
        this.categoryRepository = productRepository;
    }

    //get all product
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    //get by id
    public Category getCategory(String id){
        Long category_id = Long.parseLong(id);
        return categoryRepository.findById(category_id).orElse(null);
    }



    public Category createCategory(Category category){
        return categoryRepository.save(category);

    }

    //update
    public void updateCategory(String id, Category data){
        Long category_id = Long.parseLong(id);
        Category category = categoryRepository.findById(category_id).orElse(null);

        if (category_id != null){
            category.setCategoryName(data.getCategoryName());


            categoryRepository.save(category);
        }

    }

    public void deleteCategory(String id){
        Long category_id = Long.parseLong(id);
        categoryRepository.deleteById(category_id);

    }

}
