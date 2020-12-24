package com.order.service;

import com.order.document.Order;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

public interface UserService<U> {
    Page<U> findAllUsers(Pageable u);
    U findUser(String u);
    U findUserByCpf(String cpf) throws NotFoundException;
    U saveUser(U u);
    void deleteUser(String cpf);
}
