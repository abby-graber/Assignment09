package com.example.assignment9.models;

import java.io.Serializable;

public class City implements Serializable {
    private String city;
    private String country;

    public City(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
