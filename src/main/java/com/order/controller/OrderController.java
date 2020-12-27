package com.order.controller;


import com.order.document.Order;
import com.order.document.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


public interface OrderController {

    @GetMapping("/findAllOrders")
    ResponseEntity<?> findAll(@RequestParam int page,@RequestParam int size);


    @GetMapping("/find/id/{orderId}")
    ResponseEntity<?> findOrderById(@PathVariable("orderId") String orderId);

    @PostMapping("/saveOrder/{id}")
    ResponseEntity<?> saveOrder(Order order, @PathVariable("id") String id, @RequestBody @Validated List<Product> products);

    @PutMapping("/update/{orderId}")
    ResponseEntity<?> updateOrderById(Order order, @PathVariable("id") String id, @RequestBody @Validated List<Product> products);

    @DeleteMapping("/delete/{orderId}")
    ResponseEntity<?> deleteOrderById(@PathVariable("orderId") String orderId);
}

