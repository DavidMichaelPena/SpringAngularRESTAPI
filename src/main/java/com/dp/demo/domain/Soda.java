package com.dp.demo.domain;

import javax.persistence.*;

@Entity
public class Soda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int calories;
    private int stock;

    @ManyToOne
    private Brand brand;

    public Soda(){}

    public Soda(String name, int calories,int stock, Brand brand) {
        this.name = name;
        this.calories = calories;
        this.stock = stock;
        this.brand = brand;
    }

    public Soda(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

