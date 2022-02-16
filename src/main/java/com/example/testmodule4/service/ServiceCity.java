package com.example.testmodule4.service;

import com.example.testmodule4.model.City;
import com.example.testmodule4.repository.IRepoCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ServiceCity implements IServiceCity {
    @Autowired
    IRepoCity iRepoCity;


    @Override
    public Page<City> findAll(Pageable pageable) {
        return iRepoCity.findAll(pageable);
    }

    @Override
    public void save(City city) {
        iRepoCity.save(city);
    }

    @Override
    public void delete(int id) {
        iRepoCity.deleteById(id);
    }

    @Override
    public Optional<City> findById(int id) {
        return iRepoCity.findById(id);
    }

    @Override
    public Page<City> findByName(Pageable pageable, String name) {
        return iRepoCity.findAllByNameContaining(pageable, name);
    }
}
