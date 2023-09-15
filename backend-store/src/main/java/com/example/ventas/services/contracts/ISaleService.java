package com.example.ventas.services.contracts;

import org.springframework.http.ResponseEntity;

import com.example.ventas.entities.Sale;

public interface ISaleService {
    public ResponseEntity<Sale> create(Sale sale);
}
