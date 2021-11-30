package com.example.demo.Product;

import com.example.demo.Category.Category;
import com.example.demo.Order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String name;
        private double price;
@ManyToOne(fetch = FetchType.EAGER, optional = true)

@JoinColumn(name="category_id")
private Category category;

@ManyToMany(mappedBy = "productEn")
private List<Order> ordrEn = new ArrayList<>();



    public Product(){}
    public Product(Long id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
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


}

