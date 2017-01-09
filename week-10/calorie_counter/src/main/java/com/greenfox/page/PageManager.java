package com.greenfox.page;

import com.greenfox.domain.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class PageManager {
    private ArrayList<Meal> itemsToDisplay = new ArrayList<>();
    private final ArrayList<String> typeOptions = new ArrayList<>(
            Arrays.asList("Breakfast", "Elevenses", "Lunch", "Snack", "Dinner", "Midnight Snack"));

    private final ListFilter listFilter;

    @Autowired
    public PageManager(ListFilter listFilter) {
        this.listFilter = listFilter;
    }

    private void generateDisplayableItems(Model model) {
        itemsToDisplay.clear();
        itemsToDisplay = listFilter.generateFilteredResults();
        model.addAttribute("meals", itemsToDisplay);
    }

    private void managePagination(Model model, long pageNumber) {
        int numberOfItems = listFilter.getItemsPerPage();
        model.addAttribute("currentPage", (int) (pageNumber));
        double maxNumberOfPages = (itemsToDisplay.size() == 0) ? 1 :
                Math.ceil(itemsToDisplay.size() / (double) numberOfItems);
        model.addAttribute("maxNumberOfPages", (int) maxNumberOfPages);
    }

    private void addFilterToPage(Model model) {
        model.addAttribute("listFilter", listFilter);
    }

    private void addTypeSummaryToPage(Model model) {
        model.addAttribute("typeCount", listFilter.summarizeTypeCount());
    }

    public void manageListPage(Model model, long pageNumber) {
        generateDisplayableItems(model);
        managePagination(model, pageNumber);
        addFilterToPage(model);
        addTypeSummaryToPage(model);
        addGeneralInfoToView(model);
    }

    private void addGeneralInfoToView(Model model){
        model.addAttribute("typeOptions", typeOptions);
    }

    public void manageEditOrNewPage(Model model, Meal meal) {
        addGeneralInfoToView(model);
        model.addAttribute("meal", meal);
    }
}
