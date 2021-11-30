package com.example.demo.Category;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping List<Category> getAll(){
        return  categoryService.getcategorys();

    }

    @PostMapping()
    public Category addOne(@RequestBody Form form){
        return  categoryService.savecategory(form.getCategory(), form.getProductId());

    }

}


class Form{
    private Category category;
    private int productid;

    public Category getCategory() {
        return category;
    }

    public int getProductId() {
        return productid;
    }


}