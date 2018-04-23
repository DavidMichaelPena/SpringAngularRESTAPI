package com.dp.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public  class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String brandName;

    public Brand(){}

    public Brand(String brandName){
        this.brandName = brandName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


}
