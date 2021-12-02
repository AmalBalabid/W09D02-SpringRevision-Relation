package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
    public class CategoryService {

        private final CategoyRepo repo;

        @Autowired
        public CategoryService(CategoyRepo repo) {
            this.repo = repo;
        }


        public Category addCategory(@RequestBody Category catergory) {
            return repo.save(catergory);
        }

        public Category getCategory(String id) {
            return repo.findById(Long.parseLong(id)).orElse(null);
        }
    }





