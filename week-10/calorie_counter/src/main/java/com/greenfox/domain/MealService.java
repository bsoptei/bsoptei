package com.greenfox.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MealService {

    private final MealRepository repository;

    @Getter
    @Setter
    private Meal currentMeal = new Meal();

    @Autowired
    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public void addMeal(Meal meal) {
        repository.save(meal);
    }

    public Meal findMealById(Long id) {
        return repository.findOne(id);
    }

    public void editMeal(String date,
                         String type,
                         String description,
                         Integer calories

    ) {
        currentMeal.setDate(LocalDate.parse(date));
        currentMeal.setType(type);
        currentMeal.setDescription(description);
        currentMeal.setCalories(calories);
        repository.save(currentMeal);
    }

    public void deleteMeal(long id) {
        repository.delete(id);
    }
}
