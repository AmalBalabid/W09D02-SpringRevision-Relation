package com.example.demo.Product;

import com.example.demo.Orders.Orders;
import com.example.demo.Orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final OrdersRepository ordersRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, OrdersRepository ordersRepository) {
        this.productRepository = productRepository;
        this.ordersRepository = ordersRepository;
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(String id){
        Integer product_id = Integer.parseInt(id);
        return productRepository.findById(product_id).orElse(null);
    }

    public Product addProduct(int id, String name, double price, int order_id){
        Product product = new Product();
        product.setProductId(Long.valueOf(id));
        product.setProductName(name);
        product.setProductPrice(price);
        Orders orders = ordersRepository.findById(order_id).orElse(null);
        product.getOrders().add(orders);
        return productRepository.save(product);
    }

    public ResponseEntity<String> deleteProduct(String id){
        int Product_id = Integer.valueOf(id);
        productRepository.deleteById(Product_id);
        return ResponseEntity.ok().body("Product id:" +id);
    }

    public void updateProduct(String id, String name){
        Integer product_id = Integer.parseInt(id);
        Product product = productRepository.findById(product_id).orElse(null);
        if (product != null){
            product.setProductName(name);

            productRepository.save(product);
        }
    }
}
