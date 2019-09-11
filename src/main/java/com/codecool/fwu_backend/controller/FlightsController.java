package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.service.FlightStorage;
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

    @GetMapping("list/{from}/{to}/{when}")
    public Map<String, List> getFlights(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("when") String when){
        return flightStorage.addRandomAmountOfFlight(from,to,when);
    }

    @PostMapping("booking/{flightId}")
    public Flight bookFlight(@PathVariable("flightId")UUID flightId) throws Exception {
        return flightStorage.bookFlight(flightId);
    }

    @GetMapping("list/bookings")
    public Map<String, List> showBookedFlights(){
        return flightStorage.getAllTheBookedFlights();
    }
}
