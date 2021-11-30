package com.example.demo.Category;

import com.example.demo.Product.Product;
import com.example.demo.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Category> getcategorys(){
        return categoryRepository.findAll();
    }

    public Category savecategory(Category category, int product_id){

        Product product = productRepository.findById(product_id).orElse(null);
        category.setProduct(product);

        return categoryRepository.save(category);
    }
}
