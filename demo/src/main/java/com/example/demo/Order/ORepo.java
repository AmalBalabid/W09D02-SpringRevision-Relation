package com.example.demo.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ORepo extends JpaRepository<Order,Long> {
}
