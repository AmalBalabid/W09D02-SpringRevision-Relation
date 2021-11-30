package com.example.demo.Product;

import com.example.demo.Orders.Orders;
import com.example.demo.Orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    public List<Product> getproducts(){
        return productRepository.findAll();
    }

    public Product getproduct(String id){

        int product_id=Integer.valueOf(id);
        return productRepository.findById(product_id).orElse(null);
    }

    public Product createProduct(Product product, int orderseId){
        Orders orders = ordersRepository.findById(orderseId).orElse(null);
        product.getOrders().add(orders);
        return productRepository.save(product);

    }

    public void deleteProduct(String id){
        int Product_id = Integer.valueOf(id);
        productRepository.deleteById(Product_id);

    }

    public void updateProduct(String id, Product data){
        int Product_id =Integer.valueOf(id);
        Product product = productRepository.findById(Product_id).orElse(null);

        if (product != null){
            product.setProductName(data.getProductName());
            product.setProductPrice(data.getProductPrice());
            productRepository.save(product);
        }
    }
}
