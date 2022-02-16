package com.example.testmodule4.repository;

import com.example.testmodule4.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRepoNation extends PagingAndSortingRepository<Nation, Integer> {
}
