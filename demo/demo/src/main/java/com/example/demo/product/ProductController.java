package com.example.demo.product;


import com.example.demo.order.Order;
import com.example.demo.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="products")
@CrossOrigin("*")
public class ProductController {
    private final ProductService ProductService;
    @Autowired
    public ProductController(ProductService ProductService) {
        this.ProductService = ProductService;
    }
    @Autowired
ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;


    @GetMapping
    public List<Product> getProducts(){
        return ProductService.getProducts();

    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return ProductService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return ProductService.createProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        ProductService.deleteProduct(id);
    }

    @PutMapping("/{productId}/orders/{orderId}")
    Product enrollOrderToProduct(
            @PathVariable Long productId,
            @PathVariable Long orderId
    ){
        Product product=productRepository.getById(productId);
        Order order=orderRepository.getById(orderId);
        product.enrollOrder(order);
        return productRepository.save(product);
    }

}
