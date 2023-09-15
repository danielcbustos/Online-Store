package com.example.ventas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ventas.entities.Sale;

import com.example.ventas.services.contracts.ISaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @PostMapping("/create")
    private ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return this.saleService.create(sale);
    }

}
