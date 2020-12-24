package com.order.service.implService;

import com.order.document.User;
import com.order.repository.UserRepository;
import com.order.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

import static org.springframework.web.client.HttpClientErrorException.*;

@Service
public class ImplUserService implements UserService<User> {
    @Autowired
    private UserRepository userRepository;

    public ImplUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Page<User> findAllUsers(Pageable pageable){
        Page<User> userPage = userRepository.findAll(pageable);
       return userPage;
    }

    @SneakyThrows
    public User findUser(String userId){
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException());
    }

    public User findUserByCpf(String cpf) throws NotFoundException {
        try {
            return userRepository.findUserByCpf(cpf);
        }catch (NotFound e){
            throw new NotFoundException();
        }
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        User user = findUser(id);
        userRepository.delete(user);
    }
}
