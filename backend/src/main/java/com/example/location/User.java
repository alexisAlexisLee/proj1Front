package com.example.location;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String username;
    private String password;

    private User(){
    }

    public String getUserName() {
        return this.username;
    }
    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(String id) {
        this.id = id;
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
                "id=" + this.id +
                ", name='" + this.username + '\'' +
                '}';
    }

}
