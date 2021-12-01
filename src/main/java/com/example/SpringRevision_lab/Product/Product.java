package com.example.SpringRevision_lab.Product;

import com.example.SpringRevision_lab.Category.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public Product(Long id, String productName, Double price, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public Product() {}


    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getProductName() {return productName;}

    public void setProductName(String productName) {this.productName = productName;}

    public Double getPrice() {return price;}

    public void setPrice(double price) {this.price = price;}

    public void setCategory(Category category){
        this.category = category;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
