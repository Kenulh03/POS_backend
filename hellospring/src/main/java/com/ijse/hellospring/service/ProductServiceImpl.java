package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.Product;
import com.ijse.hellospring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existProduct = productRepository.findById(id).orElse(null);

        if(existProduct == null) {
            return null;
        }

        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setQty(product.getQty());
        existProduct.setCategory(product.getCategory());

        return productRepository.save(existProduct);
    }

    @Override
    public void deleteProduct(Long id){
         productRepository.deleteById(id);
    }
    
}
