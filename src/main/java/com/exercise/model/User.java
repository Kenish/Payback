package com.exercise.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class User extends BaseEntity  {
    @NotNull
    private String firstName;

    @NotNull
    private String surname;

    @NotNull
    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    Set<Address> addresses;

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
}
