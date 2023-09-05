package com.workintech.restapi.FruitsVegetablesApplication.services;

import com.workintech.restapi.FruitsVegetablesApplication.dao.FruitRepository;
import com.workintech.restapi.FruitsVegetablesApplication.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FruitServiceImpl implements  FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> get() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit getById(int id) {
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if (fruit.isPresent()){
            return fruit.get();
        }return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }


    @Override
    public void delete(Fruit fruit) {

        fruitRepository.delete(fruit);
    }

    @Override
    public List<Fruit> findAllPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> findAllPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> findAllDataName(String name) {
        return fruitRepository.getAllData(name);
    }
}
