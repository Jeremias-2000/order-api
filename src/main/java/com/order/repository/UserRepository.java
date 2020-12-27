package com.order.repository;

import com.order.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findUserByCpf(String cpf);
    Optional<User> findByEmail(String email);


}
