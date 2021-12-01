package com.example.demo.Order;

import com.example.demo.Product.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="order")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double price;
    private Date date;

//    @ManyToMany(mappedBy = "products_orders")
//    Set<Product> product;
    public order() {
    }

    public order(Long id, double price, Date date) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
