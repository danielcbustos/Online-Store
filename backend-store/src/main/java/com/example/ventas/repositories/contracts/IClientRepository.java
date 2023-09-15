package com.example.ventas.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ventas.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}
