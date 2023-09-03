package com.example.ventas.services.implementations;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ventas.entities.Product;
import com.example.ventas.repositories.contracts.IProductRepository;
import com.example.ventas.services.contracts.IProductService;

@Service
public class ProductService implements IProductService {
    private static final Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ResponseEntity<List<Product>> findAll() {
        try {
            // throw new Exception();
            List<Product> products = this.productRepository.findAll();

            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } catch (Exception e) {

            logger.error("Error, se presento un error al obtener la lista de productos" +
                    "\nerror: " + e);

            logger.info(
                    "Trace " + e.getStackTrace()[0].getFileName() + " Line " + e.getStackTrace()[0].getLineNumber());
            logger.info("Trace " + e.getStackTrace()[1].getFileName());
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Product> create(Product product) {
        try {
            Product productSaves = this.productRepository.save(product);
            // System.out.println("xxxxxxxxxxxx" + productSaves.getCategory().getId());
            return new ResponseEntity<Product>(productSaves, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println("error: " + e);
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<Product> update(Product product) {
        try {
            Product productUpdated = this.productRepository.save(product);
            return new ResponseEntity<Product>(productUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            this.productRepository.deleteById(id);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Product>> productsWithHigherPrice(Double price) {
        try {
            List<Product> products = this.productRepository.productsWithHigherPrice(price);
            return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public ResponseEntity<Product> findByName(String name) {
        try {
            Product product = this.productRepository.findByNameIgnoreCase(name);
            if (product != null) {
                return new ResponseEntity<Product>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
