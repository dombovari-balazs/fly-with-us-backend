package com.codecool.fwu_backend.service;


import com.codecool.fwu_backend.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightStorage {
    private List<Flight> flights = new ArrayList<>();

    @Autowired
    private FlightCreator flightCreator2;

    public Flight addFlight(String to, String from, String when){
        Flight flight = flightCreator2.createFlight(to,from,when);
        this.flights.add(flight);
        return flight;

    }
}
