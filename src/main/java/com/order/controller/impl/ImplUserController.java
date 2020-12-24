package com.order.controller.impl;

import com.order.controller.UserController;
import com.order.document.User;
import com.order.service.implService.ImplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.data.crossstore.ChangeSetPersister.*;
import static org.springframework.web.client.HttpServerErrorException.*;

@RestController
@RequestMapping("/api/v1/user")
public class ImplUserController implements UserController {
    @Autowired
    private ImplUserService implUserService;


    @Override
    public ResponseEntity<?> findAllUsers(int page,int quantity) {
        Pageable pageable = PageRequest.of(page, quantity);
        return ResponseEntity.ok(implUserService.findAllUsers(pageable));
    }

    @Override
    public ResponseEntity<?> findUser(String id) {
        return ResponseEntity.ok(implUserService.findUser(id));
    }

    @Override
    public ResponseEntity<?> findUserByCpf(String cpf) throws NotFoundException {
        try {
            return ResponseEntity.ok(implUserService.findUserByCpf(cpf));
        }catch (HttpClientErrorException.NotFound e){
            return ResponseEntity.notFound().build();
        }catch (InternalServerError error){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> saveUser(User user) {
        return new ResponseEntity<>(implUserService.saveUser(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        implUserService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}