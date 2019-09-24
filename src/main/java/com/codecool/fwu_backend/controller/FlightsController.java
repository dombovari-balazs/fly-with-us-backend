package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.FlightStorage;
import com.codecool.fwu_backend.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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


    @GetMapping("list")
    @ResponseBody
    public HashMap<String,List> getFlights(@RequestParam String from, @RequestParam String to, @RequestParam String when){
        flightService.addRandomAmountOfFlight(to,from,when);
        HashMap<String,List> response = new HashMap<>();
        response.put("Flights",flightStorage.getFlights());
        return response;
    }

    @PostMapping("booking")
    public Flight bookFlight(@RequestBody Flight flight) throws Exception {
        System.out.println(flight.toString());
        return flightService.bookFlight(flight.getId());
    }

    @GetMapping("list/bookings")
    public List<Flight> showBookedFlights(){
        return flightStorage.getBookedFlight();
    }
}
