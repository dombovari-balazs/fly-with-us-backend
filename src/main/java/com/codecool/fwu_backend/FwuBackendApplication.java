package com.codecool.fwu_backend;

import com.codecool.fwu_backend.service.FlightCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class FwuBackendApplication {


    @Autowired
    private FlightCreator flightCreator;

    public static void main(String[] args) {
        SpringApplication.run(FwuBackendApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){
        return args -> {

        };
    }

}
