package com.order.controller.impl;

import com.order.controller.UserController;
import com.order.document.User;
import com.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class ImplUserController implements UserController {
    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity<?> findAllUsers( int page,  int quantity) {
        Pageable pagination = PageRequest.of(page, quantity);
        return ResponseEntity.ok(userService.findAllUsers(pagination));
    }

    @Override
    public ResponseEntity<?> findUser(String id) {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @Override
    public ResponseEntity<?> saveUser(User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}