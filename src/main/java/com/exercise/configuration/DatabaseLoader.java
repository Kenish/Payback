package com.exercise.configuration;

import com.exercise.model.User;
import com.exercise.repository.AddressRepository;
import com.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserService userService;
    private final AddressRepository addressRepository;
    @Autowired
    DatabaseLoader(UserService userService,AddressRepository addressRepository){
        this.userService=userService;
        this.addressRepository=addressRepository;
    }

    @Override
    @Order(1)
    public void run(String... strings) throws Exception {
        User user1 = new User("jan","Kowalski","Kowalski@wp.pl");
        User user2 = new User("Janina","Kowalska","Kowalska@gmail.com");
        User user3 = new User("Janusz","Tracz","Tracz@olkeip.pl");
        User user4 = new User("Kuba","Ryba","ryby@gmail.com");
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);

    }
}
