package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }
    public User listById(int id){
        return userRepository.findById(id);
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public void delete(User user){
        userRepository.delete(user);
    }

}
