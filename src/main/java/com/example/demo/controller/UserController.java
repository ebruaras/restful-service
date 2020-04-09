package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping("/allUser")
    public List<User> getAllUser(){
        logger.debug("list all users");
        return userService.listAll();
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable(value = "id")int id){
        logger.debug("list user by id");
        return userService.listById(id);
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user){
        logger.debug("create user");
        return userService.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@Valid @RequestBody @PathVariable(value = "id")int id){
        logger.debug("delete user");
        User user=userService.listById(id);
        userService.delete(user);
        return "deleted";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@Valid @RequestBody @PathVariable(value = "id")int id, User user){
        logger.debug("update user");
        User userr=userService.listById(id);
        userr.setName(user.getName());
        User user1=userService.save(userr);
        return "changed";
    }

}
