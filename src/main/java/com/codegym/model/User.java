package com.codegym.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Khong dc de trong dau ban oi =))")
    private String firstName;

    @NotEmpty(message = "Khong dc de trong dau ban oi =))")
    private String lastName;

    private String address;
    @NotEmpty
    @Email(message = "Ga` the , sai dinh dang email roi -_-")
    private String email;

    @NotEmpty(message = "Khong dc de trong dau ban oi =))")
    private String userName;

    @NotEmpty(message = "Khong dc de trong dau ban oi =))")
    private String password;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String address, String email, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
