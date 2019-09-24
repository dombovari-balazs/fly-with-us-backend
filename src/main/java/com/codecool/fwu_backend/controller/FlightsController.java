package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
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
    private AvailableFlightStorage flightStorage;

    @Autowired
    private FlightService flightService;

    @GetMapping("test")
    public String test(){
        return "Server is running";
    }

    @GetMapping("list/{from}/{to}/{when}")
    public HashMap<String,List> getFlights(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("when") String when){
        flightService.addRandomAmountOfFlight(to,from,when);

    @GetMapping("list/{from}/{to}/{when}")
    public HashMap<String,List> getFlights(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("when") String when){

        HashMap<String,List> response = new HashMap<>();
        response.put("Flights",flightStorage.getFlightsByCityFromAndCityToAndDate(from,to,when));
        return response;
    }


   // @GetMapping("list/bookings")

}
