package com.greenfoxacademy.controllers;

import com.greenfoxacademy.domain.Meal;
import com.greenfoxacademy.domain.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("")
public class CalorieController {

    private final MealRepository repository;
    private final ArrayList<String> typeOptions = new ArrayList<>(
            Arrays.asList("Breakfast","Elevenses", "Lunch", "Snack", "Dinner", "Midnight Snack"));

    @Autowired
    public CalorieController(MealRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("meals", repository.findAll());
        return "list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/index");
    }

    @GetMapping("/new")
    public String newMealForm(Model model) {
        model.addAttribute("typeOptions", typeOptions);
        model.addAttribute("meal", new Meal());
        return "new";
    }

    @PostMapping("/new")
    public String addNewMeal(@ModelAttribute Meal meal) {
        repository.save(meal);
        return "redirect:/index";
    }

    @PostMapping("/edit")
    public ModelAndView update(@RequestParam("id") Long id,
                               @RequestParam("date") String date,
                               @RequestParam("type") String type,
                               @RequestParam("description") String description,
                               @RequestParam("calories") Integer calories) {
        Meal meal = repository.findOne(id);
        meal.setDate(date);
        meal.setType(type);
        meal.setDescription(description);
        meal.setCalories(calories);
        repository.save(meal);
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long id,
                       Model model) {
        Meal meal = repository.findOne(id);
        model.addAttribute("typeOptions", typeOptions);
        model.addAttribute("meal", meal);
        return "edit";
    }

}
