package com.epam.inventorymanagement.repository;

import com.epam.inventorymanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    // Additional custom queries or methods can be added here if needed

}