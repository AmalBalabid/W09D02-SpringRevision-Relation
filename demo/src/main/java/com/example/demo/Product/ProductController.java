package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Product> getAllProducts(){
        return productsService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productsService.getProduct(id);
    }


    @PostMapping
    @ResponseBody
    public void addProduct(@RequestParam String id, @RequestParam String name, @RequestParam  double price,  @RequestParam  int order_id){
        productsService.addProduct(Integer.valueOf(id), name, price, order_id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delProduct(@PathVariable String id){
        return productsService.deleteProduct(id);
    }

    @PutMapping
    @ResponseBody
    public void updateProduct(@RequestParam String id, @RequestParam String name){
        productsService.updateProduct(id,name);
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