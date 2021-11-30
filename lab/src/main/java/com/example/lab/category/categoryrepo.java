package com.example.lab.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryrepo extends JpaRepository<category, Integer> {
}