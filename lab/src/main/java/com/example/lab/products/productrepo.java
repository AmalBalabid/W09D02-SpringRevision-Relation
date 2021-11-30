package com.example.lab.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productrepo extends JpaRepository<product, Integer> {
}