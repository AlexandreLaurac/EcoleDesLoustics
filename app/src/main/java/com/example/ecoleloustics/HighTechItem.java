package com.example.ecoleloustics;

public class HighTechItem {

    //attributs

    private String name;
    private int price;

    //constructeurs


    public HighTechItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //méthodes


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
