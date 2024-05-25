package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.Product;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id,Product product);
    void deleteProduct(Long id);
}

