package com.example.demo.Category;


import com.example.demo.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="categories")
public class CController {

    private final CService cService;

    @Autowired
    public CController(CService cService) {
        this.cService = cService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return  cService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable String id){
        return  cService.getCategory(id);
    }

    @PostMapping
    public Category postCategory(@RequestBody Category category){
        return cService.postCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id){
        cService.deleteCategory(id);

    }
}
