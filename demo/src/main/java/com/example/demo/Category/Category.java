package com.example.demo.Category;

import com.example.demo.Product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "product_id")
    private Product product;
    public Category() {
    }

    public Category(Long id, String name, Product product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
