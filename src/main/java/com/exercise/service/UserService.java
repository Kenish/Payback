package com.exercise.service;

import com.exercise.model.Address;
import com.exercise.model.User;
import com.exercise.repository.AddressRepository;
import com.exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository repository;
    private final AddressRepository addressRepository;


    @Autowired
    public UserService(UserRepository repository,AddressRepository addressRepository){
        this.repository=repository;
        this.addressRepository=addressRepository;
    }

    public HttpStatus addUser(User user){
        if (emailIsValid(user.getEmail())) {
            repository.saveAndFlush(user);
            return HttpStatus.CREATED;
        }
        else {
            return HttpStatus.CONFLICT;
        }
    }

    private boolean emailIsValid(String email){
        return email.matches("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public List<User> getUserList(){
        return repository.findAll();
    }

    public HttpStatus deleteUser(Long id){
        repository.delete(id);
        return HttpStatus.GONE;
    }

    public User getUser(long id){
        return repository.findOne(id);
    }

    public Set<Address> getAddress(long id){
        return repository.findOne(id).getAddresses();
    }

    public HttpStatus addAddress(long id,Address address){
        addressRepository.save(address);
        User user = repository.findOne(id);
        user.addAddress(address);
        repository.saveAndFlush(user);
        return HttpStatus.CREATED;
    }

}
