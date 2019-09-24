package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FlightCreator {
    public Flight createFlight(String to, String from, String when){
        return Flight.builder()
                .cityFrom(from)
                .cityTo(to)
                .date(when)
                .build();
    }
}
