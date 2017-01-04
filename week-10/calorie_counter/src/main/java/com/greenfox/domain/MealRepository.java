package com.greenfox.domain;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("ALL")
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByDateBetweenAndTypeLike(LocalDate start, LocalDate end, String type, Sort sort);

    @Query(value = "select sum(calories) from meals where (date between :startDate and :endDate) and type like :type", nativeQuery = true)
    Integer sumCaloriesFilterByDateAndType(@Param("startDate")LocalDate start,
                                           @Param("endDate") LocalDate end,
                                           @Param("type") String type);


    @Query(value = "select type, count(type) from meals where (date between :startDate and :endDate) and type like :type group by type", nativeQuery = true)
    List<Object[]> typeCountFilterByDateAndType(@Param("startDate")LocalDate start,
                                                @Param("endDate") LocalDate end,
                                                @Param("type") String type);
}
