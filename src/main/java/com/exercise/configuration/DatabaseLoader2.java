package com.exercise.configuration;

import com.exercise.model.Address;
import com.exercise.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader2 implements CommandLineRunner{
    private final UserService userService;
    public DatabaseLoader2(UserService userService){
        this.userService=userService;
    }
    @Override
    @Order(2)
    public void run(String... strings) throws Exception {

        Address address1 = new Address("Polska","Skarzysko",123,"zeromskiego 46");
        Address address2 = new Address("Polska","Warszawa",456,"moldawska 56");
        Address address3 = new Address("Anglia","Londyn",5679,"knightsbride 5454");
        userService.addAddress(1,address1);
        userService.addAddress(2,address2);
        userService.addAddress(3,address3);

    }
}
