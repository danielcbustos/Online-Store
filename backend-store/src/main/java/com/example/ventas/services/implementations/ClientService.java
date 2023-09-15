package com.example.ventas.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ventas.entities.Category;
import com.example.ventas.entities.Client;
import com.example.ventas.repositories.contracts.IClientRepository;
import com.example.ventas.services.contracts.IClientService;

@Service
public class ClientService implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public ResponseEntity<List<Client>> findAll() {
        try {

            List<Client> clients = this.clientRepository.findAll();

            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("error: " + e);
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Client>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Client> create(Client client) {
        try {
            Client clientSaves = this.clientRepository.save(client);

            return new ResponseEntity<Client>(clientSaves, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<Client> update(Long id, Client client) {
        try {
            Optional<Client> existingClient = this.clientRepository.findById(id);
            if (existingClient.isPresent()) {
                Client updClient = existingClient.get();
                updClient.setName(client.getName());
                updClient.setIdentification(client.getIdentification());
                Client clientUpdated = this.clientRepository.save(updClient);
                return new ResponseEntity<Client>(clientUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            this.clientRepository.deleteById(id);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
