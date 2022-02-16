package com.example.testmodule4.repository;

import com.example.testmodule4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRepoCity extends PagingAndSortingRepository<City, Integer> {

    Page<City> findAllByNameContaining(Pageable pageable, String name);
}
