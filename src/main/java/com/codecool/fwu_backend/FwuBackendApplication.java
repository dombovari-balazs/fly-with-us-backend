package com.codecool.fwu_backend;

import com.codecool.fwu_backend.model.Airport;
import com.codecool.fwu_backend.model.Product;
import com.codecool.fwu_backend.model.PublicTransport;
import com.codecool.fwu_backend.model.enums.City;
import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.AirportRepository;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import com.codecool.fwu_backend.repository.ProductRepository;
import com.codecool.fwu_backend.repository.PublicTransportRepository;
import com.codecool.fwu_backend.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@Slf4j
public class FwuBackendApplication {

    @Autowired
    private AvailableFlightStorage flightStorage;

    @Autowired
    private PublicTransportRepository publicTransportRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private ProductRepository productRepository;

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

            Flight example2 = Flight.builder()
                    .cityFrom(City.BUDAPEST.name())
                    .cityTo(City.BARCELONA.name())
                    .date("2019-09 -25")
                    .build();
            example2.fillUpWithGeneratedValues();

            flightStorage.saveAndFlush(example2);

            log.info(flightStorage.findAll().toString());

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

            log.info(liszt_ferenc_airport.toString());


        };
    }
}