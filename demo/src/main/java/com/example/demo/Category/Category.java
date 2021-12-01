package com.example.demo.Category;

import com.example.demo.Product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL)
    private List<Product> product=new ArrayList<>();

    public Category() {
    }


    public Category(Long categoryId, String categoryName, List<Product> product) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.product = product;
    }

    public Long getCategoryId () {
            return categoryId;
        }

        public void setCategoryId (Long categoryId){
            this.categoryId = categoryId;
        }

        public String getCategoryName () {
            return categoryName;
        }

        public void setCategoryName (String categoryName){
            this.categoryName = categoryName;
        }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}


