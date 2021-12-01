package com.example.demo.order;

import com.example.demo.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OrderId;

    private double orderPrice;
    private Date orderDate;

@JsonIgnore
    @ManyToMany(mappedBy = "orders")
    private List<Product> products=new ArrayList<>();

    public Order(Long orderId, double orderPrice, Date orderDate, List<Product> products) {
        OrderId = orderId;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.products = products;
    }

    public Order (){}


    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Order{" +
                "OrderId=" + OrderId +
                ", orderPrice=" + orderPrice +
                ", orderDate=" + orderDate +
                '}';
    }
}
