package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.FlightStorage;
import com.codecool.fwu_backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightsController {

    @Autowired
    private FlightStorage flightStorage;

    @Autowired
    private FlightService flightService;

    @GetMapping("test")
    public String test(){
        return "Server is running";
    }

    @GetMapping("list/{from}/{to}/{when}")
    public HashMap<String,List> getFlights(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("when") String when){
        flightService.addRandomAmountOfFlight(to,from,when);
        HashMap<String,List> response = new HashMap<>();
        response.put("Flights",flightStorage.getFlights());
        return response;
    }

    @PostMapping("booking/{flightId}")
    public Flight bookFlight(@PathVariable("flightId")UUID flightId) throws Exception {
        return flightService.bookFlight(flightId);
    }

    @GetMapping("list/bookings")
    public List<Flight> showBookedFlights(){
        return flightStorage.getBookedFlight();
    }
}
