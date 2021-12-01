package com.example.demo.Product;

import com.example.demo.Category.Category;
import com.example.demo.Order.order;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String name;
    private double price ;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Order> Order = new ArrayList<Order>();

    public Product() {
    }

    public Product(long id, String name, double price, Collection<org.hibernate.criterion.Order> order) {
        this.id = id;
        this.name = name;
        this.price = price;
        Order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Collection<org.hibernate.criterion.Order> getOrder() {
        return Order;
    }

    public void setOrder(Collection<org.hibernate.criterion.Order> order) {
        Order = order;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", Order=" + Order +
                '}';
    }
}
