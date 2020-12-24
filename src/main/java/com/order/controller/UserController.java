package com.order.controller;

import com.order.document.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping("/findAll")
    ResponseEntity<?> findAllUsers(@RequestParam int page,@RequestParam int quantity);

    @GetMapping("/find/id/{id}")
    ResponseEntity<?> findUser(@PathVariable("id") String id);

    @GetMapping("/find/cpf/{cpf}")
    ResponseEntity<?> findUserByCpf(@PathVariable("cpf") String cpf) throws ChangeSetPersister.NotFoundException;


    @PostMapping("/save")
    ResponseEntity<?> saveUser(@RequestBody @Validated User user);


    @DeleteMapping("/delete/id/{id}")
    ResponseEntity<?> deleteUser(@PathVariable("id") String id);

}
