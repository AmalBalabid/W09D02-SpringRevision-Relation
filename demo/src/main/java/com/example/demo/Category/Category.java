package com.example.demo.Category;

import com.example.demo.Product.Product;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;


    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "product_id")
    private Product product;


    public Category() {
    }

    public Category(Long id, String title, Product product) {
        this.id = id;
        this.title = title;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
