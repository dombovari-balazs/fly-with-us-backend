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
        Stream.generate(() -> new Flight(to, from, when) ).limit(random.nextInt(20)).forEach(flightStorage::add);
    }

//    public Flight bookFlight(UUID flightId) throws Exception {
//        Flight bookable = findFlight(flightId);
//        bookedFlight.add(bookable);
//        return bookable;
//    }
//
//    public Flight findFlight(UUID flightId) throws Exception {
//        for (Flight flight : flights) {
//            if (flight.getId().equals(flightId)){
//                return flight;
//            }
//        }
//        throw new Exception("Flight not found");
//    }
//
//    public Map<String,List> getAllTheBookedFlights(){
//        Map<String,List> allBookedFlights= new HashMap<>();
//        allBookedFlights.put("Bookings", bookedFlight);
//        return allBookedFlights;
//    }

}
