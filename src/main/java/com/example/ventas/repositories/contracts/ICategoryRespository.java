package com.example.ventas.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ventas.entities.Category;

public interface ICategoryRespository extends JpaRepository<Category, Long> {

}
