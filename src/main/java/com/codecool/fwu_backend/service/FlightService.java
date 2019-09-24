package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.FlightStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class FlightService {

    @Autowired
    private FlightStorage flightStorage;

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
                    flightStorage.add(flight);
                });
    }

    public Flight findFlight(Long id) throws Exception {
        for (Flight flight : flightStorage.getFlights()) {
            if (flight.getId().equals(id)){
                return flight;
            }
        }
        throw new Exception("Flight not found");
    }

    public Flight bookFlight(Long id) throws Exception {
        Flight bookable = findFlight(id);
        flightStorage.bookFlight(bookable);
        return bookable;
    }
}
