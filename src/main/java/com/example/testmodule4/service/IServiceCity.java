package com.example.testmodule4.service;

import com.example.testmodule4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface IServiceCity {
    public Page<City> findAll(Pageable pageable);
    public void save(City city);
    public void delete(int id);
    public Optional<City> findById(int id);
    public Page<City> findByName(Pageable pageable, String name);
}
