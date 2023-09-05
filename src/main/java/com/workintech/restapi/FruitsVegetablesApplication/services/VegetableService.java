package com.workintech.restapi.FruitsVegetablesApplication.services;

import com.workintech.restapi.FruitsVegetablesApplication.entity.Fruit;
import com.workintech.restapi.FruitsVegetablesApplication.entity.Vegetable;

import java.util.List;

public interface VegetableService {


    List<Vegetable> get();
    Vegetable getById(int id);
    Vegetable save(Vegetable vegetable);
    void delete(Vegetable vegetable);

    List<Vegetable> findByPriceDesc();
    List<Vegetable> findAllPriceAsc();
    List<Vegetable> findAllDataName(String name);

}
