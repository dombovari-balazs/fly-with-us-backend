package com.codecool.fwu_backend.model;

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

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", cityTo='" + cityTo + '\'' +
                ", cityFrom='" + cityFrom + '\'' +
                ", date='" + date + '\'' +
                ", classQuality=" + classQuality +
                ", price=" + price +
                ", company=" + company +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getCityTo() {
        return cityTo;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public String getDate() {
        return date;
    }

    public ClassQuality getClassQuality() {
        return classQuality;
    }

    public double getPrice() {
        return price;
    }

    public Company getCompany() {
        return company;
    }
}
