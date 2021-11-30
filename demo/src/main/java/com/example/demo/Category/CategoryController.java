package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("category")
public class CategoryController {

        private final CategoryServies categoryServies;
        @Autowired


    public CategoryController(CategoryServies categoryServies) {
        this.categoryServies = categoryServies;
    }

    @GetMapping
        public List<Category> getCategory(){
            return categoryServies.getCategory();
        }
        @PostMapping
        public Category addCategory(@RequestBody Category category){
            return categoryServies .addCategory( category);
        }
}
