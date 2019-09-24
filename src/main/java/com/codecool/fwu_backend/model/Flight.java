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
    private Company company;1

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

    public Flight() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClassQuality(ClassQuality classQuality) {
        this.classQuality = classQuality;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
