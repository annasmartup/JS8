package com.example.users_store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private int yearBirth;


    public User(String name, String phoneNumber, String address, int yearBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.yearBirth = yearBirth;
    }
}
