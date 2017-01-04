package com.greenfox.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="meals")
@Data
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String type;
    private String description;
    private Integer calories;

    public Meal() {
    }

    public Meal(String type, LocalDate date, String description, Integer calories) {
        this.date = date;
        this.type = type;
        this.description = description;
        this.calories = calories;
    }
}
