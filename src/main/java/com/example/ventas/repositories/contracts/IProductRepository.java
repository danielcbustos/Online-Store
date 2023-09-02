package com.example.ventas.repositories.contracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ventas.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products AS p " +
            "WHERE price > :price", nativeQuery = true)
    public List<Product> productsWithHigherPrice(@Param("price") Double price);

    public Product findByNameIgnoreCase(@Param("name") String name);
}
