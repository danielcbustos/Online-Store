package com.example.ventas.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ventas.entities.Sale;

import com.example.ventas.repositories.contracts.ISaleRepository;
import com.example.ventas.services.contracts.ISaleService;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public ResponseEntity<Sale> create(Sale sale) {
        try {
            Sale saleSaves = this.saleRepository.save(sale);
            return new ResponseEntity<Sale>(saleSaves, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Sale>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
