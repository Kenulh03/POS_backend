package com.ijse.hellospring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.hellospring.dto.OrderProductDto;
import com.ijse.hellospring.entity.Order;
import com.ijse.hellospring.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(){
        Order order = new Order();

        order.setTotalPrice(0.0);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderedProducts(null);

        return orderService.createOrder(order);
    }

    @PostMapping("/orders/{id}/addProduct")
    public Order addProductToOrder(@PathVariable Long id, @RequestBody OrderProductDto orderProductDto){
        return orderService.addProductToOrder(id, orderProductDto.getProductId(), orderProductDto.getQuantity());
    }

    @DeleteMapping("/orders/{orderId}/product/{productId}")
    public Order removeProductFromOrder(@PathVariable Long orderId,@PathVariable Long productId) {
        return orderService.removeProductFromOrder(orderId, productId);
    }

    @PutMapping("/orders/{orderId}")
    public Order completeOrder(@PathVariable Long orderId){
        return orderService.completeOrder(orderId);
    }

}
