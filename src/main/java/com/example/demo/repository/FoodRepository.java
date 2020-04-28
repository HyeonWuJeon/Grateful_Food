package com.example.demo.repository;

import com.example.demo.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {


    @Query("SELECT f FROM Food f where f.id = :id")
    Food findOne(Long id);

    @Query("SELECT f FROM Food f where f.name = :name")
    List<Food> findByName(String name);



}
