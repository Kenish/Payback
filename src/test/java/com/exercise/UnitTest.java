package com.exercise;

import com.exercise.model.Address;
import com.exercise.model.User;
import com.exercise.repository.AddressRepository;
import com.exercise.repository.UserRepository;
import com.exercise.service.UserService;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.*;

public class UnitTest {
    private UserRepository userRepository;
    private UserService userService ;
    @Before
    public void StartUp(){
        userRepository = mock(UserRepository.class);
        AddressRepository addressRepository=mock(AddressRepository.class);
        userService= new UserService(userRepository,addressRepository);
    }
    @Test
    public void BadEmailShouldReturnConflictStatus(){

        User user = new User("ab","ba","pp@wp,pl");
        Assert.assertEquals(userService.addUser(user),HttpStatus.CONFLICT );
    }
    @Test
    public void ProperEmailShouldReturnAcceptedStatusAndSaveUser(){
        User user = new User("ab","ba","foo@bar.com");
        Assert.assertEquals(userService.addUser(user),HttpStatus.CREATED);
        verify(userRepository).saveAndFlush(user);
    }

}
