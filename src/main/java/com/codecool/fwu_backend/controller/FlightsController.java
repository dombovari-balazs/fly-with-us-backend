package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.service.FlightStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class FlightsController {
    @Autowired
    private FlightStorage flightStorage;

    @GetMapping("/flight/{from}/{to}/{when}")
    public Map<String, List> getFlights(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("when") String when){
        return flightStorage.addRandomAmountOfFlight(from,to,when);
    }
}
