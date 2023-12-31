package com.example.ventas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ventas.entities.Category;
import com.example.ventas.services.contracts.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    private ResponseEntity<List<Category>> getAllCategory() {
        return this.categoryService.findAll();
    }

    @PostMapping("/create")
    private ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return this.categoryService.create(category);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return this.categoryService.update(id, category);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        return this.categoryService.delete(id);
    }

}
