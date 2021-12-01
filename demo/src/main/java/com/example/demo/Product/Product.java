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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "products_orders", joinColumns = @JoinColumn(name = "product_id",
            referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "order_id",
            referencedColumnName = "id"))
    private Collection<order> order;

    public Product() {
    }

    public Product(long id, String name, double price, Category category, Collection<com.example.demo.Order.order> order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.order = order;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<com.example.demo.Order.order> getOrder() {
        return order;
    }

    public void setOrder(Collection<com.example.demo.Order.order> order) {
        this.order = order;
    }
}
