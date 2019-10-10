package com.codecool.fwu_backend.model.dto;

import com.codecool.fwu_backend.model.Flight;
import lombok.Data;

@Data
public class FlightDto {
    private Long id;
    private String cityTo;
    private String cityFrom;
    private String date;
    private double price;

    public FlightDto(Flight flight) {
        this.id = flight.getId();
        this.cityTo = flight.getCityTo();
        this.cityFrom = flight.getCityFrom();
        this.date = flight.getDate();
        this.price = flight.getPrice();
    }
}
