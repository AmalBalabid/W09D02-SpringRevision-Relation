package com.example.lab.products;

import com.example.lab.category.category;
import com.example.lab.orders.orders;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;

//    fist way :
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private category category;


//  second way
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private category category;


//    Manytomany first way
//    @ManyToMany
//    @JoinTable(
//        name = "Product_Order",
//        joinColumns = @JoinColumn(name = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "order_id")
//    )
//    List<orders> OrderProduct = new ArrayList<>();

//    public List<orders> getOrderProduct() {
//        return OrderProduct;
//    }

//    second way
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<orders> Order = new ArrayList<>();



    public product(){}

    public product(int id, String name, int price, category category, Collection<orders> Order) {
        this.id = id;
        this.name=name;
        this.price=price;
        this.category=category;
        this.Order=Order;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public Collection<orders> getOrder() {
        return Order;
    }

    public void setOrder(Collection<orders> order) {
        Order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
