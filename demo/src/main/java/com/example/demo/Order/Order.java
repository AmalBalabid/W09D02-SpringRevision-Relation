package com.example.demo.Order;

import com.example.demo.Product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private double orderPrice;
    private String orderData;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "order_en",
            joinColumns = {
                    @JoinColumn(name = "order_id"
                )},
            inverseJoinColumns = {
                    @JoinColumn(name ="product_id")})
    private List<Product> productEn = new ArrayList<>();


    public Order(Long orderId, double orderPrice, String orderData) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.orderData = orderData;
    }
    public Order(){}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }
   public List<Product> getProductEn() {
      return productEn;
  }

   public void setProductEn(List<Product> productEn) {
     this.productEn = productEn;
  }

}
