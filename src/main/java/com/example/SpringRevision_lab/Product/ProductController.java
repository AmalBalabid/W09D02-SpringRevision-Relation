package com.example.SpringRevision_lab.Product;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProduct(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct (@RequestBody Product product){
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable String id, @RequestBody Product data){
        productService.updateProduct(id, data);
    }
}
