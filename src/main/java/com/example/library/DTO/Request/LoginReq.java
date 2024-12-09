package com.example.library.DTO.Request;

// Declares the LoginReq class which is a simple Data Transfer Object (DTO) for handling login requests.
// This class are typically used in  Auth controller to receive data from HTTP requests and pass it to service layers for processing.
public class LoginReq {

    private String username;
    private String password;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}