package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "product")
public class ProductController{
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<String>getIdandName(@RequestParam String Id,@RequestParam String Name){
        return ResponseEntity.ok().body(Id +"" +Name);
    }
    @GetMapping("/{id}")
    public Product GetProduct(@PathVariable String id ){
        return productService.getProduct(id);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.AddProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable String id){
      return productService.deleteProduct(id);

    }

}
