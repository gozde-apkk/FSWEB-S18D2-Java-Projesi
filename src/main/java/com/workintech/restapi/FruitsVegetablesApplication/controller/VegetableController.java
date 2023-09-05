package com.workintech.restapi.FruitsVegetablesApplication.controller;


import com.workintech.restapi.FruitsVegetablesApplication.entity.Fruit;
import com.workintech.restapi.FruitsVegetablesApplication.entity.Vegetable;
import com.workintech.restapi.FruitsVegetablesApplication.exceptions.FruitException;
import com.workintech.restapi.FruitsVegetablesApplication.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> get(){
       return vegetableService.get();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable int id){
        Vegetable vegetable = vegetableService.getById(id);
        if (vegetable == null){
            throw new FruitException("Vegetables with given id is not exist: " + id, HttpStatus.BAD_REQUEST);
        }
        return vegetable;
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc(){
        return vegetableService.findByPriceDesc();
    }

    @GetMapping("/asc")
    public List<Vegetable> getByPriceAsc(){
        return vegetableService.findAllPriceAsc();
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name){
        return vegetableService.findAllDataName(name);
    }


    @PostMapping("/")
    public Vegetable save(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable int id){
        Vegetable vegetable = getById(id);
         vegetableService.delete(vegetable);
         return vegetable;
    }

}
