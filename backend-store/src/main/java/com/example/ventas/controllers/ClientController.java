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
import org.springframework.web.bind.annotation.RestController;

import com.example.ventas.entities.Client;
import com.example.ventas.services.contracts.IClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("/list")
    private ResponseEntity<List<Client>> getAllClients() {
        return this.clientService.findAll();
    }

    @PostMapping("/create")
    private ResponseEntity<Client> createUser(@RequestBody Client client) {
        return this.clientService.create(client);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return this.clientService.update(id, client);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> deleteClient(@PathVariable Long id) {
        return this.clientService.delete(id);
    }
}
