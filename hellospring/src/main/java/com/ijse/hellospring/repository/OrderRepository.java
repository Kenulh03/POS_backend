package com.ijse.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.hellospring.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
