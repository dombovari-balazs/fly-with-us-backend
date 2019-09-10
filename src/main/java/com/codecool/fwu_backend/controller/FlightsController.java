package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.component.Flight;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class FlightsController {

    @GetMapping("/hello")
    public String getHello(){
        return "helloWorld";
    }

    @GetMapping("/flight/{from}/{to}/{when}")
    public List<Flight> getFlights(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("when") String when){
        List<Flight> cheapFlights = new ArrayList<>();
        cheapFlights.add(new Flight(to, from, when));
        cheapFlights.add(new Flight(to, from, when));
        cheapFlights.add(new Flight(to, from, when));
        return cheapFlights;
    }
}
