package com.fundraiser.fundraiser.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class User extends AbstractEntity {
    @NotBlank(message = "Username can not be blank.")
    @Size(min = 1, max = 25, message = "Invalid username, must be between 1-25 characters.")
    private String username;

    @Email(message = "Invalid Email, try again.")
    @NotBlank(message = "Email can not be blank.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "password is required.")
    private String password;

//    Default constructor
    public User(){

    }

//    Constructor with parameters
    public User(String username, String email, String password){
        super();
        this.username = username;
        this.email = email;
        this. password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
