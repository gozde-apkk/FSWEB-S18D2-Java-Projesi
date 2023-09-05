package com.workintech.restapi.FruitsVegetablesApplication.services;

import com.workintech.restapi.FruitsVegetablesApplication.dao.VegetableRepository;
import com.workintech.restapi.FruitsVegetablesApplication.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class VegetableServiceImplement implements VegetableService {


    private  VegetableRepository  vegetableRepository;

    @Autowired
    public VegetableServiceImplement(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> get() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable getById(@PathVariable int id) {
        Optional<Vegetable> vegetable=  vegetableRepository.findById(id);
        if (vegetable.isPresent()){
            vegetable.get();
        }
        return null;
    }

    @Override
    public Vegetable save(@RequestBody  Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Vegetable vegetable) {
        vegetableRepository.delete(vegetable);
    }

    @Override
    public List<Vegetable> findByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }


    @Override
    public List<Vegetable> findAllPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> findAllDataName(String name) {
        return null;
    }
}
