package com.exercise.controller;

import com.exercise.model.User;
import com.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/api/user",method = RequestMethod.GET)
    List<User> getUsers(){
        return userRepository.findAll();
    }
}
