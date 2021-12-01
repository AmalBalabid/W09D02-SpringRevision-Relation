package com.example.demo.product;
import com.example.demo.categroy.Category;
import com.example.demo.order.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String productName;
    private double productPrice;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "categoryId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    public Product(Long productId, String productName, double productPrice, Category category, List<Order> orders) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
        this.orders = orders;
    }



    @ManyToMany
    @JoinTable(
            name = "order_enrolled",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders=new ArrayList<>();


    public Product(){}



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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", category=" + category +
                '}';
    }

    public void enrollOrder(Order order) {
       orders.add(order);
    }
}
