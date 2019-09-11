package com.codecool.fwu_backend.service;


import com.codecool.fwu_backend.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightStorage {

    private List<Flight> flights = new ArrayList<>();
    private List<Flight> bookedFlight = new ArrayList<>();

    Random random = new Random();

    @Autowired
    private FlightCreator flightCreator2;

    public Flight addFlight(String to, String from, String when){
        Flight flight = flightCreator2.createFlight(to,from,when);
        this.flights.add(flight);
        return flight;

    }

    public Map<String, List> addRandomAmountOfFlight(String to, String from, String when){
        Map<String, List> randomFlights = new HashMap<>();
        List<Flight> cheapFlights = new ArrayList<>();
        for (int i = 0; i < random.nextInt(20); i++) {
            cheapFlights.add(addFlight(to, from, when));
        }
        randomFlights.put("Flights", cheapFlights);
        return randomFlights;
    }

    public Flight bookFlight(UUID flightId) throws Exception {
        Flight bookable = findFlight(flightId);
        bookedFlight.add(bookable);
        return bookable;
    }

    public Flight findFlight(UUID flightId) throws Exception {
        for (Flight flight : flights) {
            if (flight.getId().equals(flightId)){
                return flight;
            }
        }
        throw new Exception("Flight not found");
    }

    public Map<String,List> getAllTheBookedFlights(){
        Map<String,List> allBookedFlights= new HashMap<>();
        allBookedFlights.put("Bookings", bookedFlight);
        return allBookedFlights;
    }

}
