package com.codecool.fwu_backend;

import com.codecool.fwu_backend.service.FlightCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FwuBackendApplication {


    @Autowired
    private FlightCreator flightCreator;

    public static void main(String[] args) {
        SpringApplication.run(FwuBackendApplication.class, args);
    }



}
