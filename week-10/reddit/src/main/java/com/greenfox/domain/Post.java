package com.greenfox.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Lenovo on 2017. 01. 04..
 */
@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String content;
    private Integer score = 0;

    public Post(){
    }

    public Post(String content) {
        this.content = content;
    }
}
