package com.example.ventas.repositories.contracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ventas.entities.Client;
import com.example.ventas.entities.Sale;

public interface ISaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findBySaleDate(Date saleDate);

    List<Sale> findByClient(Client client);

    List<Sale> findByClientAndSaleDateBetween(Client client, Date startDate, Date endDate);
}
