package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.Category;
import com.ijse.hellospring.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
  @Autowired
  private CategoryRepository categoryRepository;

@Override
public List<Category> getAllCategories() {
return categoryRepository.findAll();
}

@Override
public Category getCategoryById(Long id) {
return categoryRepository.findById(id).orElse(null);
}

@Override
public Category createCategory(Category category) {
return categoryRepository.save(category);
}

@Override
public Category updateCategory(Long id,Category category){
Category existCategory = categoryRepository.findById(id).orElse(null);

if(existCategory == null) {
    return null;
}

existCategory.setName(category.getName());


return categoryRepository.save(existCategory);
  
}
}
