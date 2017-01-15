package com.greenfox.services;

import com.greenfox.domain.Meal;
import com.greenfox.repository.MealRepository;
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

    public void saveMeal(Meal meal) {
        repository.save(meal);
    }

    public Meal findMealById(Long id) {
        return repository.findOne(id);
    }

    public void editMeal(Meal oldMeal, Meal newMeal) {
        oldMeal.setDate(newMeal.getDate());
        oldMeal.setType(newMeal.getType());
        oldMeal.setDescription(newMeal.getDescription());
        oldMeal.setCalories(newMeal.getCalories());
        saveMeal(oldMeal);
    }

    public void deleteMeal(long id) {
        repository.delete(id);
    }
}
