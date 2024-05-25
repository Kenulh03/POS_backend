package com.ijse.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.hellospring.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
