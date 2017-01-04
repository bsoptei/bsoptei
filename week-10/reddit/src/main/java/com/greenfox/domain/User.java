package com.greenfox.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;

    public User(){
    }

    public User(String userName) {
        this.userName = userName;
    }
}
