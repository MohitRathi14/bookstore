package com.example.bookstore.online_bookstore.Dto;

public class UserDTO {

    private String username;
    private String password;  // Plain password for registration
    private String role;      // Optional, can default to USER

    public UserDTO() {}

    public UserDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
