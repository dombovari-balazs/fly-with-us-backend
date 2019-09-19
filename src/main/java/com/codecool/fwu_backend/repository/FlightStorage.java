package com.codecool.fwu_backend.repository;


import com.codecool.fwu_backend.model.Flight;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightStorage {

    private List<Flight> flights = new ArrayList<>();
    private List<Flight> bookedFlight = new ArrayList<>();

    public void add(Flight flight){
        this.flights.add(flight);
    }

    public List<Flight> getFlights(){
        return new ArrayList<>(flights);
    }


}
