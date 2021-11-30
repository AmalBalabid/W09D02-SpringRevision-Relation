package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

@Service
public class ProductServies {

    private final ProductRepository productRepository;
@Autowired
    public ProductServies(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product getProduct(String id){
        return productRepository.findById(Long.parseLong(id)).orElse(null);
    }


    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct( Product data) {

        Product updatedProduct =  productRepository.findById(data.getId()).orElseThrow(() -> new InvalidConfigurationPropertyValueException(Long.toString(data.getId()), data, " the specified product does not exist"));
        updatedProduct.setId(data.getId());
        updatedProduct.setName(data.getName());
        updatedProduct.setPrice(data.getPrice());
        return productRepository.save(updatedProduct);
    }
    

    public String deleteProduct(String id) {
        String response = "";
        Product product =productRepository.findById(Long.parseLong(id)).orElse(null);
        if (product != null) {
            productRepository.deleteById(Long.parseLong(id));
            response = "deleted";
        }
        else
            response = "Product not found";
        return response;
    }


//    public Product updateProduct(Product product) {
//        Product updatedProduct =  productRepository.findById(product.getId()).orElseThrow(() -> new InvalidConfigurationPropertyValueException(Long.toString(product.getId()), product, " the specified product does not exist"));
//        updatedProduct.setId(product.getId());
//        updatedProduct.setName(product.getName());
//        updatedProduct.setPrice(product.getPrice());
//        return productRepository.save(updatedProduct);
//
//    }
}



