package com.codecool.fwu_backend.config;

import com.codecool.fwu_backend.service.FlightCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class CreateConfig {

    @Bean
    public FlightCreator flightCreator2(){
        return new FlightCreator();
    }

    @Bean
    public Random random(){return new Random();}
}
