package com.example.SpringRevision_lab.Orders;

import com.example.SpringRevision_lab.Product.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double orderPrice;
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
//    private Date orderDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Product> products = new ArrayList<>();

    public Orders() {
    }

    public Orders(Long id, Double orderPrice, Collection<Product> products) {
        this.id = id;
        this.orderPrice = orderPrice;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderDate() {

        Date timestamp = new Date(new Date().getTime());
        return timestamp;
    }

//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
