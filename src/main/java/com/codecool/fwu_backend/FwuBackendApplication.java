package com.codecool.fwu_backend;

import com.codecool.fwu_backend.model.City;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import com.codecool.fwu_backend.service.FlightCreator;
import com.codecool.fwu_backend.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.accessibility.AccessibleValue;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
@Slf4j
public class FwuBackendApplication {

    @Autowired
    private AvailableFlightStorage flightStorage;
    public FwuBackendApplication(FlightService flightService) {
        this.flightService = flightService;
    }

    private FlightService flightService;

    public static void main(String[] args) {
        SpringApplication.run(FwuBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            //flightService.addRandomAmountOfFlight(City.BUDAPEST.name(),City.BARCELONA.name(), "2019-09-24");
            //log.info(flightService.getOneFlight().toString());

            Flight example = Flight.builder()
                    .cityFrom(City.BUDAPEST.name())
                    .cityTo(City.BARCELONA.name())
                    .date("2019-09-24")
                    .build();
            example.fillUpWithGeneratedValues();

            flightStorage.saveAndFlush(example);

            log.info(flightStorage.findAll().toString());


        };
    }
}