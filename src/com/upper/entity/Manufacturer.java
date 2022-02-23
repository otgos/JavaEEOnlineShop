package com.upper.entity;

public class Manufacturer {
    private Long id;
    private String name;
    private String country;
    private String shortName;

    public Manufacturer(Long id, String name, String country, String shortName) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.shortName = shortName;
    }
    public Manufacturer(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
