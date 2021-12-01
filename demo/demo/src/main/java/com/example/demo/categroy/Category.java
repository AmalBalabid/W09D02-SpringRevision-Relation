package com.example.demo.categroy;

import com.example.demo.product.Product;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;


    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private List<Product> product=new ArrayList<>();


    public Category(){}

    public Category(Long categoryId, String categoryName, List<Product> product) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.product = product;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void  setProduct(List<Product> product) {
        this.product = product;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", product=" + product +
                '}';
    }
}
