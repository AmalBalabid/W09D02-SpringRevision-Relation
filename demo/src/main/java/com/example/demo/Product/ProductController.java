package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductServies productServies;
    @Autowired
    public ProductController(ProductServies productServies) {
        this.productServies = productServies;
    }
//@GetMapping
//    public ResponseEntity<String> getIdAndName(@RequestParam String id, @RequestParam String name){
//        return ResponseEntity.ok().body(id + " " + name);
//
//    }
@GetMapping
public List<Product> getProducts(){
        return productServies.getProducts();
}

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productServies.addProduct(product);
    }



//    @PutMapping
//    public Product updateProduct(@RequestBody Product product){
//        return productServies.updateProduct(product);
//    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        return ResponseEntity.ok().body(productServies.deleteProduct(id));
    }
}