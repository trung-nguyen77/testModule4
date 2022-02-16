package com.example.testmodule4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double area;
    private int population;
    private double gdp;
    private String description;
    @ManyToOne
    private Nation nation;

}
