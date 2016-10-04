package com.exercise;

import com.exercise.model.Address;
import com.exercise.model.User;
import com.exercise.repository.AddressRepository;
import com.exercise.repository.UserRepository;
import com.exercise.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaybackAppTest {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;

    @Test
    public void userServiceShouldAddUserAndReturnCreatedStatus(){
        User user2 = new User("blabla","w","blabla@gmail.com");
        given(this.userService.addUser(user2)).willReturn(HttpStatus.CREATED);
    }
}
