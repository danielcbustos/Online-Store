package com.example.ventas.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ventas.entities.Category;
import com.example.ventas.repositories.contracts.ICategoryRespository;
import com.example.ventas.services.contracts.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRespository categoryRepository;

    @Override
    public ResponseEntity<List<Category>> findAll() {
        try {
            List<Category> categories = this.categoryRepository.findAll();
            return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<List<Category>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Category> create(Category category) {
        try {
            Category categorySaves = this.categoryRepository.save(category);
            return new ResponseEntity<Category>(categorySaves, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<Category> update(Category category) {
        try {
            Category categoryUpdated = this.categoryRepository.save(category);
            return new ResponseEntity<Category>(categoryUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Category>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            this.categoryRepository.deleteById(id);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
