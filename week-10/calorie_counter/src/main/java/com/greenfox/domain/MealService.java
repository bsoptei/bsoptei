package com.greenfox.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MealService {

    private final MealRepository repository;

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

    public void editMeal(Long id,
                         String date,
                         String type,
                         String description,
                         Integer calories

    ) {
        Meal meal = findMealById(id);
        meal.setDate(LocalDate.parse(date));
        meal.setType(type);
        meal.setDescription(description);
        meal.setCalories(calories);
        repository.save(meal);
    }

    public void deleteMeal(long id) {
        repository.delete(id);
    }
}
