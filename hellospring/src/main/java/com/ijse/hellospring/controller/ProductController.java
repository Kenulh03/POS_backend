package com.ijse.hellospring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.dto.ProductDto;
import com.ijse.hellospring.entity.Category;
import com.ijse.hellospring.entity.Product;
import com.ijse.hellospring.service.CategoryService;
import com.ijse.hellospring.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);

        if(product == null){
            return ResponseEntity.status(404).build();
        }else{
            return ResponseEntity.status(200).body(product);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQty(productDto.getQty());
        
        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);

        Product createProduct = productService.createProduct(product);
        return ResponseEntity.status(201).body(createProduct);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQty(productDto.getQty());

        Category category = categoryService.getCategoryById(productDto.getCategoryId());
        product.setCategory(category);

        Product updateProduct = productService.updateProduct(id, product);//use the service layer to update product

        if(updateProduct == null){
            return ResponseEntity.status(404).build();
        }else{
            return ResponseEntity.status(200).body(updateProduct);
        }
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
