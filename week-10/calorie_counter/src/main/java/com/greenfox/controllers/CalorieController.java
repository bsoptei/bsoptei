package com.greenfox.controllers;

import com.greenfox.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class CalorieController {

    private final FilterManager filterManager;
    private final PageManager pageManager;
    private ListFilter listFilter;
    private final MealService mealService;

    @Autowired
    public CalorieController(ListFilter listFilter,
                             PageManager pageManager,
                             FilterManager filterManager,
                             MealService mealService) {
        this.listFilter = listFilter;
        this.pageManager = pageManager;
        this.filterManager = filterManager;
        this.mealService = mealService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "redirect:/list/1";
    }

    @RequestMapping(value = "/list/{pageNumber}")
    public String list(@PathVariable long pageNumber, Model model) {
        pageManager.manageListPage(model, pageNumber);
        return "list";
    }

    @RequestMapping(value = "/{id}/confirmdelete")
    public String confirmDelete(@PathVariable long id, Model model) {
        model.addAttribute("meal", mealService.findMealById(id));
        return "confirm";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        mealService.deleteMeal(id);
        return "redirect:/index";
    }

    @GetMapping("/new")
    public String newMealForm(Model model) {
        pageManager.manageEditOrNewPage(model, new Meal());
        return "new";
    }

    @PostMapping("/new")
    public String addNewMeal(@ModelAttribute Meal meal,
                             @RequestParam(value = "addAnother", defaultValue = "") String addAnother) {
        mealService.addMeal(meal);
        return (addAnother.equals("Submit and add another")) ? "redirect:/new" : "redirect:/index";
    }

    @GetMapping("/editfilter")
    public String updateFilter(@RequestParam("startDate") String startDate,
                               @RequestParam("endDate") String endDate,
                               @RequestParam("type") String type,
                               @RequestParam("itemsPerPage") String itemsPerPage,
                               @RequestParam("sortCriteria") String sortBy) {
        filterManager.changeFilterCriteria(
                startDate,
                endDate,
                type,
                itemsPerPage,
                sortBy
        );
        return "redirect:/index";
    }

    @RequestMapping("/resetfilter")
    public String resetFilter() {
        listFilter.initializeFilter();
        return "redirect:/index";
    }

    @PostMapping("/edit")
    public String update(@RequestParam("id") Long id,
                         @RequestParam("date") String date,
                         @RequestParam("type") String type,
                         @RequestParam("description") String description,
                         @RequestParam("calories") Integer calories) {
        mealService.editMeal(id,
                date,
                type,
                description,
                calories);
        return "redirect:/index";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long id,
                       Model model) {
        pageManager.manageEditOrNewPage(model, mealService.findMealById(id));
        return "edit";
    }

}
