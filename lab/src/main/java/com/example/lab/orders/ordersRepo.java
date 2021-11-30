package com.example.lab.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ordersRepo extends JpaRepository<orders, Integer> {
}