package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="products")
class ProductController {

    private final ProductService productsService;

    @Autowired
    public ProductController(ProductService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productsService.getproducts();

    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productsService.getproduct(id);

    }

    @PostMapping
    public Product createProduct(@RequestBody Form form){
        return productsService.createProduct(form.getProduct(), form.getOrderId());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        productsService.deleteProduct(id);

    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable String id, @RequestBody Product data){
        productsService.updateProduct(id, data);
    }
}


class Form{
    private Product product;
    private int order_id;


    public Product getProduct() {
        return product;
    }

    public int getOrderId() {
        return order_id;
    }


}