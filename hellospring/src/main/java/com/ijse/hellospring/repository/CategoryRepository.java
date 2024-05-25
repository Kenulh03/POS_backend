package com.ijse.hellospring.repository;

import com.ijse.hellospring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
