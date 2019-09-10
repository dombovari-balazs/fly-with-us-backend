package com.codecool.fwu_backend.component;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;


public class Flight {

    private UUID id;
    private String cityTo;
    private String cityFrom;
    private String date;
    private ClassQuality classQuality;
    private double price;
    private Company company;



    public Flight(String cityTo, String cityFrom, String date) {
        Random random = new Random();
        this.id = UUID.randomUUID();
        this.cityTo = cityTo;
        this.cityFrom = cityFrom;
        this.date = date;
        this.classQuality = ClassQuality.getRandomClass();
        this.price = 10 + random.nextDouble()*100;
        this.company = Company.getRandomClass();
    }
}
