package com.example.testmodule4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNation;
    private String name;

    public Nation() {
    }

    public Nation(int idNation, String name) {
        this.idNation = idNation;
        this.name = name;
    }

    public long getIdNation() {
        return idNation;
    }

    public void setIdNation(int idNation) {
        this.idNation = idNation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
