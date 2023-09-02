package com.example.ventas.services.contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ventas.entities.Category;

public interface ICategoryService {
    public ResponseEntity<List<Category>> findAll();

    public ResponseEntity<Category> create(Category category);

    public ResponseEntity<Category> update(Category category);

    public ResponseEntity<Boolean> delete(Long id);
}
