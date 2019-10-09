package com.codecool.fwu_backend;

import com.codecool.fwu_backend.model.*;
import com.codecool.fwu_backend.model.enums.City;
import com.codecool.fwu_backend.repository.*;
import com.codecool.fwu_backend.service.FlightCreator;
import com.codecool.fwu_backend.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.accessibility.AccessibleValue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@Slf4j
public class FwuBackendApplication {

    private AvailableFlightStorage flightStorage;
    private FlightService flightService;
    private MovieStorage movieStorage;
    private PublicTransportRepository publicTransportRepository;
    private AirportRepository airportRepository;
    private ProductRepository productRepository;
    private TravelAgentStorage travelAgentStorage;

    public FwuBackendApplication(AvailableFlightStorage flightStorage,
                                 FlightService flightService,
                                 MovieStorage movieStorage,
                                 PublicTransportRepository publicTransportRepository,
                                 AirportRepository airportRepository,
                                 ProductRepository productRepository,
                                 TravelAgentStorage travelAgentStorage) {
        this.flightStorage = flightStorage;
        this.flightService = flightService;
        this.movieStorage = movieStorage;
        this.publicTransportRepository = publicTransportRepository;
        this.airportRepository = airportRepository;
        this.productRepository = productRepository;
        this.travelAgentStorage = travelAgentStorage;
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

            Flight example = Flight.builder()
                    .cityFrom(City.BUDAPEST.name())
                    .cityTo(City.BARCELONA.name())
                    .date("2019-09-24")
                    .oneMovie(movie1)
                    .build();
            example.fillUpWithGeneratedValues();
            movie1.setFlights(Collections.singletonList(example));

            movieStorage.save(movie1);
            flightStorage.save(example);


            TravelAgent travelAgent = TravelAgent.builder()
                    .name("WizHair")
                    .rating(5f)
                    .website("localhost")
                    .flight(example)
                    .build();


            travelAgentStorage.save(travelAgent);



            Flight example2 = Flight.builder()
                    .cityFrom(City.BUDAPEST.name())
                    .cityTo(City.BARCELONA.name())
                    .date("2019-09 -25")
                    .build();
            example2.fillUpWithGeneratedValues();

            flightStorage.saveAndFlush(example2);


            PublicTransport bkk = PublicTransport.builder()
                    .name("BKK")
                    .build();
            bkk.fillUpGeneratedTimes();
            publicTransportRepository.save(bkk);

            Airport liszt_ferenc_airport = Airport.builder()
                    .city(City.BUDAPEST)
                    .name("Liszt Ferenc Airport")
                    .publicTransport(bkk)
                    .flights(flightStorage.findAll())
                    .build();
            airportRepository.save(liszt_ferenc_airport);

            Product beer = Product.builder()
                    .name("Beer")
                    .description("Beer is one of the oldest and most widely consumed alcoholic drinks in the world. It is also the third most popular drink overall after water and tea. ")
                    .oneAirport(liszt_ferenc_airport)
                    .build();

            productRepository.save(beer);
            liszt_ferenc_airport.setProducts(productRepository.findAll());
            airportRepository.save(liszt_ferenc_airport);



        };
    }
}