package com.exercise.configuration;

import com.exercise.model.User;
import com.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    @Autowired
    DatabaseLoader(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user1 = new User("pszemek","ste","123");
        User user2 = new User("natalka","w","natalkaW@gmail.com");
        userRepository.saveAndFlush(user1);
        userRepository.saveAndFlush(user2);
    }
}
