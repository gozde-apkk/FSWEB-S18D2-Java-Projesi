package com.workintech.restapi.FruitsVegetablesApplication.controller;

import com.workintech.restapi.FruitsVegetablesApplication.entity.Fruit;
import com.workintech.restapi.FruitsVegetablesApplication.exceptions.FruitException;
import com.workintech.restapi.FruitsVegetablesApplication.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@Validated
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> get(){
        return fruitService.get();
    }
    @GetMapping("/{id}")
    public Fruit getById(@PathVariable  int id){
        Fruit fruit = fruitService.getById(id);
        if (fruit == null){
            throw new FruitException("Fruit with given id is not exist: " + id, HttpStatus.BAD_REQUEST);
        }
        return fruit;
    }

    @PostMapping("/")
    public Fruit save(@Validated @RequestBody  Fruit fruit){

        return fruitService.save(fruit);
    }

    @PostMapping("/{name}")
    public List<Fruit> save(@PathVariable String name){
        return fruitService.findAllDataName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable int id){
        Fruit fruit = getById(id);
        fruitService.delete(fruit);
        return fruit;
    }
}
