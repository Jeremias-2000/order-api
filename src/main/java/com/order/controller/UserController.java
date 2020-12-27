package com.order.controller;

import com.order.document.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

public interface UserController {

    @GetMapping("/findAll")
    ResponseEntity<?> findAllUsers(Pageable pageable);
    @GetMapping("/find/id/{id}")
    ResponseEntity<?> findUser(@PathVariable("id") String id);


    @GetMapping("/find/cpf/{cpf}")
    ResponseEntity<?> findUserByCpf(@PathVariable("cpf") String cpf) throws NotFoundException;


    @PostMapping("/save")
    ResponseEntity<?> saveUser(@RequestBody @Validated User user);


    @DeleteMapping("/delete/id/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") String id);

}
