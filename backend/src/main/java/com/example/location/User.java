package com.example.location;

import org.springframework.data.annotation.Id;
import java.util.UUID;

public class User {
    @Id
    private UUID id;
    private String username;

    private User(UUID id, String username){
        this.id = id;
        this.username = username;
    }

    public String getUserName() {
        return this.username;
    }
    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + this.id +
                ", name='" + this.username + '\'' +
                '}';
    }

}
