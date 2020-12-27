package com.order.controller.impl;


import com.order.controller.OrderController;
import com.order.document.Order;
import com.order.document.Product;
import com.order.document.User;
import com.order.service.implService.ImplOrderService;
import com.order.service.implService.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

import static org.springframework.web.client.HttpClientErrorException.*;


@RestController
@RequestMapping("/api/v1/order")
public class ImplOrderController implements OrderController {

        @Autowired
        private ImplOrderService implOrderService;

        @Autowired
        private ImplUserService implUserService;

        public ImplOrderController(ImplOrderService implOrderService, ImplUserService implUserService) {
                this.implOrderService = implOrderService;
                this.implUserService = implUserService;
        }

        @Override
        public ResponseEntity<?> findAll(int page,int size) {
                return ResponseEntity.ok(implOrderService.findAllOrders(page,size));
        }


        @Override
        public ResponseEntity<?> findOrderById(String orderId) {
                try {
                        return ResponseEntity.ok(orderId);
                }catch (HttpServerErrorException.InternalServerError error){
                        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }

        @Override
        public ResponseEntity<?> saveOrder(Order order, String id, List<Product> products) {
                User search = implUserService.findUser(id);
                order = new Order(order.getOrderId(),search,products);
                return new ResponseEntity<>(implOrderService.save(order),HttpStatus.CREATED);
        }



        @Override
        public ResponseEntity<?> updateOrderById(Order order, String id, List<Product> products) {
                return null;
        }

        @Override
        public ResponseEntity<?> deleteOrderById(String orderId) {
               try {
                       implOrderService.deleteOrder(orderId);
                       return ResponseEntity.ok().build();
               }catch (NotFound exception){
                       return ResponseEntity.notFound().build();
               }catch (HttpServerErrorException.InternalServerError error){
                       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
               }
        }
}
