package com.workintech.restapi.FruitsVegetablesApplication.dao;

import com.workintech.restapi.FruitsVegetablesApplication.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository  extends JpaRepository<Fruit, Integer> {


    @Query("SELECT f FROM Fruit f ORDER BY f.price desc")
    List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit as f ORDER BY f.price asc")
    List<Fruit> getByPriceAsc();


    @Query("SELECT f FROM Fruit f WHERE f.name ilike %:name%")
    List<Fruit> getAllData(String name);
}
