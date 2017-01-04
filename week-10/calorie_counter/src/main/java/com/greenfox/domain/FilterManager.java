package com.greenfox.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FilterManager {

    private ListFilter listFilter;

    @Autowired
    public FilterManager(ListFilter listFilter) {
        this.listFilter = listFilter;
    }

    public void changeListFilterDateCriteria(String startDate, String endDate) {
        if (!startDate.equals("")) {
            listFilter.setStartDate(LocalDate.parse(startDate));
        }
        if (!endDate.equals("")) {
            listFilter.setEndDate(LocalDate.parse(endDate));
        }
    }

    public void changeListFilterTypeCriteria(String type) {
        listFilter.setType(type);
    }

    public void changeListFilterSort(String sortBy) {
        if (!sortBy.equals("")) {
            String[] sortDirectionAndProperty = sortBy.split(" ");
            listFilter.setSortCriteria((new Sort(
                    Sort.Direction.fromString(sortDirectionAndProperty[0]),
                    sortDirectionAndProperty[1])));
        }
    }

    public void changeListFilterItemsPerPage(String itemsPerPage) {
        listFilter.setItemsPerPage(Integer.parseInt(itemsPerPage));
    }

    public void changeFilterCriteria(String startDate, String endDate, String type, String itemsPerPage, String sortBy) {
        changeListFilterDateCriteria(startDate, endDate);
        changeListFilterTypeCriteria(type);
        changeListFilterItemsPerPage(itemsPerPage);
        changeListFilterSort(sortBy);
    }
}
