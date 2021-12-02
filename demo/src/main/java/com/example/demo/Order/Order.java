package com.example.demo.Order;
import com.example.demo.Product;

import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private Date date;
    @ManyToMany
    private List<Product> products;

    public Order() {
    }

    public Order(Long id, Double price, Date date) {
        this.id = id;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
