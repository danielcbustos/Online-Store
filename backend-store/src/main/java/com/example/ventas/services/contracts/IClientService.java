package com.example.ventas.services.contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ventas.entities.Client;

public interface IClientService {

    public ResponseEntity<List<Client>> findAll();

    public ResponseEntity<Client> create(Client client);

    public ResponseEntity<Client> update(Long id, Client client);

    public ResponseEntity<Boolean> delete(Long id);
}
