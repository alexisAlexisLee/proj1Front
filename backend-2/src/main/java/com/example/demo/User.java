package com.example.demo;


public class User {
    private String username;
    private String password;

    private User(){
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User {" +
                "name='" + this.username + '\'' +
                '}';
    }
}
