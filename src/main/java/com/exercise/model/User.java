package com.exercise.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User extends BaseEntity  {
    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.PERSIST,targetEntity =Address.class)
    @JoinColumn(name = "USER_id")
    private Set<Address> addresses;

    public User(){}//jpa

    public User(String firstName, String surname, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public String getSurname() {

        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void addAddress(Address address){
        addresses.add(address);
    }
}
