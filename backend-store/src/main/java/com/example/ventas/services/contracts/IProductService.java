package com.example.ventas.services.contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ventas.entities.Product;

public interface IProductService {
    public ResponseEntity<List<Product>> findAll();

    public ResponseEntity<Product> create(Product product);

    public ResponseEntity<Product> update(Long id, Product product);

    public ResponseEntity<Boolean> delete(Long id);

    public ResponseEntity<List<Product>> productsWithHigherPrice(Double price);

    public ResponseEntity<Product> findByName(String name);
}
