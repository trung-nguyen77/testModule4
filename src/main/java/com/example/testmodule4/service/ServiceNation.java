package com.example.testmodule4.service;


import com.example.testmodule4.model.Nation;
import com.example.testmodule4.repository.IRepoNation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceNation implements IServiceNation{

    @Autowired
    IRepoNation iRepoNation;

    @Override
    public List<Nation> findAll() {
        return (List<Nation>) iRepoNation.findAll();
    }

}
