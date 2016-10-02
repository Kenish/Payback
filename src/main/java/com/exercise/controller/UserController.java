package com.exercise.controller;

import com.exercise.model.Address;
import com.exercise.model.User;
import com.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getUserList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpStatus addUser(@RequestBody User user){
       return userService.addUser(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public HttpStatus removeUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/{id}/addresses",method = RequestMethod.GET)
    public Set<Address> getAddresses(@PathVariable Long id){
        return userService.getAddress(id);
    }

    @RequestMapping(value = "/{id}/addresses",method = RequestMethod.POST)
    public HttpStatus getAddresses(@PathVariable Long id,@RequestBody Address address){
        return userService.addAddress(id,address);
    }
}
