package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightCreator {
    public Flight createFlight(String to, String from, String when){
        return new Flight(to,from,when);
    }
}
