package com.greenfox.page;

import com.greenfox.domain.Meal;
import com.greenfox.repository.MealRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@ToString
public class ListFilter {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Integer itemsPerPage;
    private String type;
    private Sort sortCriteria;

    private ListFilter() {
        initializeFilter();
    }

    @Autowired
    public MealRepository repository;

    @Bean
    public ListFilter getListFilter() {
        return new ListFilter();
    }

    public void initializeFilter() {
        resetStartDate();
        resetEndDate();
        setItemsPerPage(5);
        setType("%");
        sortCriteria = new Sort(Sort.Direction.DESC, "date");
    }

    private void resetStartDate() {
        setStartDate(LocalDate.of(2010, 1, 1));
    }

    private void resetEndDate() {
        setEndDate(LocalDate.of(2020, 12, 31));
    }

    public ArrayList<Meal> generateFilteredResults() {
        ArrayList<Meal> filteredResults = new ArrayList<>();
        filteredResults.addAll(repository.findByDateBetweenAndTypeLike(
                startDate,
                endDate,
                type,
                sortCriteria
        ));
        return filteredResults;
    }

    public List<Object[]> summarizeTypeCount() {
        return repository.typeCountFilterByDateAndType(
                startDate,
                endDate,
                type);
    }

    public Integer calculateTotalCalories() {
        return repository.sumCaloriesFilterByDateAndType(
                startDate,
                endDate,
                type);
    }
}
