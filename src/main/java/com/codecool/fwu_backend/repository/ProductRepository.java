package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
