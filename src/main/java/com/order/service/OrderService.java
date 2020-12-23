package com.order.service;

import com.order.document.Order;
import com.order.document.Product;
import com.order.document.User;
import com.order.repository.OrderRepository;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.crossstore.ChangeSetPersister.*;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @SneakyThrows
    public Order findById(String orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(()
                -> new NotFoundException());
    }

    @SneakyThrows
    public Order findOrder(String id){
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }



    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(String orderId) {
        Order search = findById(orderId);
        orderRepository.delete(search);
    }
}