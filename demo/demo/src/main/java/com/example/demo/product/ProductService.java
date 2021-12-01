package com.example.demo.product;

import com.example.demo.categroy.Category;
import com.example.demo.categroy.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Autowired

    public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    public Product createProduct(Product product ){
        Long category_id=product.getCategory().getCategoryId();
       Category category=categoryRepository.getById(category_id);
       System.out.println(product.toString());
       if(category !=null){
           product.setCategory(category);
           return productRepository.save(product);
       }
        return null;
    }



    public void deleteProduct(String id){
        Long product_id = Long.parseLong(id);
        productRepository.deleteById(product_id);

    }


    //get all products
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    //get by id
    public Product getProduct(String id){
        Long product_id = Long.parseLong(id);
        return productRepository.findById(product_id).orElse(null);
    }






}
