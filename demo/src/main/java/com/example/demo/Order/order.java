package com.example.demo.Order;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    private Date date;


    public order() {
    }

    public order(Long id, Double price, Date date) {
        this.id = id;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
