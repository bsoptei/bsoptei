package com.greenfox.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="meals")
@Data
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String date;
    private String type;
    private String description;
    private Integer calories;

    public Meal() {
    }

    public Meal(String type, String date, String description, Integer calories) {
        this.date = date;
        this.type = type;
        this.description = description;
        this.calories = calories;
    }
}
