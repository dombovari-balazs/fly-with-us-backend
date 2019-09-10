package com.codecool.fwu_backend.config;

import com.codecool.fwu_backend.service.FlightCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreaterConfig {

    @Bean
    public FlightCreator flightCreator2(){
        return new FlightCreator();
    }
}
