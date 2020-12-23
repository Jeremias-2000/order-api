package com.order.service;

import com.order.document.User;
import com.order.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.crossstore.ChangeSetPersister.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Page<User> findAllUsers(Pageable pageable){
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage;
    }

    @SneakyThrows
    public User findUser(String userId){
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException());
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        User user = findUser(id);
        userRepository.delete(user);
    }
}
