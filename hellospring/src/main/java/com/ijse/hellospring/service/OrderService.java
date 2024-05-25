package com.ijse.hellospring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.hellospring.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order addProductToOrder(Long orderId,Long productId,int quantity);
    Order removeProductFromOrder(Long orderId, Long productId);
    Order completeOrder(Long orderId);
}
