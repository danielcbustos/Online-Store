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

import com.example.ventas.entities.Product;
import com.example.ventas.services.contracts.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    private ResponseEntity<List<Product>> getAllProducts() {
        return this.productService.findAll();
    }

    @GetMapping("/productWithHigherPrice")
    private ResponseEntity<List<Product>> productWithHigherPrice(@RequestParam("price") Double price) {
        return this.productService.productsWithHigherPrice(price);
    }

    @GetMapping("/findByName")
    private ResponseEntity<Product> findByName(@RequestParam("name") String name) {
        return this.productService.findByName(name);
    }

    @PostMapping("/create")
    private ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return this.productService.create(product);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return this.productService.update(id, product);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> deleteProduct(@PathVariable Long id) {
        return this.productService.delete(id);
    }
}
