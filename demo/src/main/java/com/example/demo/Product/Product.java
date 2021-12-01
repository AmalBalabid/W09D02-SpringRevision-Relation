package com.example.demo.Product;

import com.example.demo.Category.Category;
import com.example.demo.Order.Order;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name="category_id")
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Category category;

   @ManyToMany(mappedBy = "product")
//
private List<Order> ordrEn = new ArrayList<>();



    public Product(){}

    public Product(Long id, String name, double price, Category category, List<Order> ordrEn) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
     this.ordrEn = ordrEn;
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

   public List<Order> getOrdrEn() {
        return ordrEn;
    }

    public void setOrdrEn(List<Order> ordrEn) {
        this.ordrEn = ordrEn;
    }
}

