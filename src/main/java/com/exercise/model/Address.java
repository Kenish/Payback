package com.exercise.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Address extends BaseEntity {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private Integer postalCode;
    @NotNull
    private String address;

    private boolean active;

    public Address(String firstName, String lastName, String country, String city, Integer postalCode, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
    }

    public Address(){}//jpa
}
