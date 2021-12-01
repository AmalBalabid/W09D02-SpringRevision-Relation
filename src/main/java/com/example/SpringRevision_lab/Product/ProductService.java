package com.example.SpringRevision_lab.Product;


import com.example.SpringRevision_lab.Category.Category;
import com.example.SpringRevision_lab.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(String id){
        Long product_id = Long.parseLong(id);
        return productRepository.findById(product_id).orElse(null);
    }
    public Product createProduct(Product product){
        Long category_id = product.getCategory().getId();
        Category category = categoryRepository.getById(category_id);
        if (category !=null){
            product.setCategory(category);
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(String id){
        Long product_id = Long.parseLong(id);
        productRepository.deleteById(product_id);
    }

    public void updateProduct(String id, Product data){
        Long product_id = Long.parseLong(id);
        Product product = productRepository.findById(product_id).orElse(null);

        if (product != null){
            product.setProductName(data.getProductName());
            product.setPrice(data.getPrice());
            productRepository.save(product);
        }
    }
}
