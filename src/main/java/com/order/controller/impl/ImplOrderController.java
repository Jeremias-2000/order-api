package com.order.controller.impl;


import com.order.controller.OrderController;
import com.order.document.Order;
import com.order.document.Product;
import com.order.document.User;
import com.order.service.OrderService;
import com.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/order")
public class ImplOrderController implements OrderController {

        @Autowired
        private OrderService orderService;

        @Autowired
        private UserService userService;

        public ImplOrderController(OrderService orderService, UserService userService) {
                this.orderService = orderService;
                this.userService = userService;
        }

        @Override
        public ResponseEntity<?> findAll() {
                return ResponseEntity.ok(orderService.findAllOrders());
        }


        @Override
        public ResponseEntity<?> findOrderById(String orderId) {
                return ResponseEntity.ok(orderId);
        }

        @Override
        public ResponseEntity<?> saveOrder(Order order, String id, List<Product> products) {
                User search = userService.findUser(id);
                order = new Order(order.getOrderId(),search,products);
                return new ResponseEntity<>(orderService.save(order),HttpStatus.CREATED);
        }



        @Override
        public ResponseEntity<?> updateOrderById(Order order, String id, List<Product> products) {
                return null;
        }

        @Override
        public ResponseEntity<?> deleteOrderById(String orderId) {
                orderService.deleteOrder(orderId);
                return ResponseEntity.ok().build();
        }
}
