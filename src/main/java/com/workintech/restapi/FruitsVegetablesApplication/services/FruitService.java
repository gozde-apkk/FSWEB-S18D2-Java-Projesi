package com.workintech.restapi.FruitsVegetablesApplication.services;

import com.workintech.restapi.FruitsVegetablesApplication.entity.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {

     List<Fruit> get();
     Fruit getById(int id);
     Fruit save(Fruit fruit);
     void delete(Fruit fruit);

     List<Fruit> findAllPriceDesc();
     List<Fruit> findAllPriceAsc();
     List<Fruit> findAllDataName(String name);


}
