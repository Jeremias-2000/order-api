package com.order.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

public interface UserService<U> {
    Page<U> findAllUsers(Pageable pageable);
    U findUser(String u);
    U findUserByCpf(String cpf) throws NotFoundException;
    U saveUser(U u);
    void deleteUser(String cpf);
}
