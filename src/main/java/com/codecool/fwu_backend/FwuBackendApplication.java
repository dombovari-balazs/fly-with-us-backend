package com.codecool.fwu_backend;

import com.codecool.fwu_backend.model.City;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.Movie;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import com.codecool.fwu_backend.repository.MovieStorage;
import com.codecool.fwu_backend.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


@SpringBootApplication
@Slf4j
public class FwuBackendApplication {

    private AvailableFlightStorage flightStorage;
    private FlightService flightService;
    private MovieStorage movieStorage;

    public FwuBackendApplication(AvailableFlightStorage flightStorage, FlightService flightService, MovieStorage movieStorage) {
        this.flightStorage = flightStorage;
        this.flightService = flightService;
        this.movieStorage = movieStorage;
    }

    public static void main(String[] args) {
        SpringApplication.run(FwuBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            //flightService.addRandomAmountOfFlight(City.BUDAPEST.name(),City.BARCELONA.name(), "2019-09-24");
            //log.info(flightService.getOneFlight().toString());
            Movie movie1 = Movie.builder()
                    .title("Airplane!")
                    .length(120)
                    .build();
            movieStorage.save(movie1);

            Flight example = Flight.builder()
                    .cityFrom(City.BUDAPEST.name())
                    .cityTo(City.BARCELONA.name())
                    .date("2019-09-24")
                    .movies(movieStorage.findAll())
                    .build();
            example.fillUpWithGeneratedValues();

            flightStorage.saveAndFlush(example);

            log.info(flightStorage.findAll().toString());


        };
    }
}