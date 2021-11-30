package com.example.demo.Product;

import com.example.demo.Orders.Orders;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private double productPrice;


    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Orders> Orders = new ArrayList<Orders>();

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Collection<com.example.demo.Orders.Orders> getOrders() {
        return Orders;
    }

    public void setOrders(Collection<com.example.demo.Orders.Orders> orders) {
        Orders = orders;
    }

    public Product(Long productId, String productName, double productPrice, Collection<com.example.demo.Orders.Orders> orders) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        Orders = orders;
    }
}