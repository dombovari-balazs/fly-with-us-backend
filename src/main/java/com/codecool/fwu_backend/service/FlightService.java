package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class FlightService {

    @Autowired
    private AvailableFlightStorage flightStorage;

    @Autowired
    private Random random;



    public void addRandomAmountOfFlight(String to, String from, String when){
        Stream.generate(() -> Flight.builder()
                .cityFrom(from)
                .cityTo(to)
                .date(when)
                .build() )
                .limit(random.nextInt(20))
                .forEach(flight -> {
                    flight.fillUpWithGeneratedValues();
                    flightStorage.save(flight);
                });
    }
    public Flight getOneFlight(){
        return flightStorage.findAll().get(0);
    }

    public List<Flight> listFlights(String from, String to, String when){
        return flightStorage.getFlightsByCityFromAndCityToAndDate(from, to, when);
    }

    public List<Flight> findAll() {
        return flightStorage.findAll();
    }
}
