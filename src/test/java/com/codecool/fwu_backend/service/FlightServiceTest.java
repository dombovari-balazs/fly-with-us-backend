package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.repository.FlightStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightServiceTest {

    @MockBean
    FlightStorage flightStorage;
    @MockBean
    Random random;

    @Autowired
    FlightService flightService;


    @Test
    public void addRandomAmountOfFlight() {
        Mockito.when(random.nextInt(anyInt())).thenReturn(20);
        flightService.addRandomAmountOfFlight("ABC", "DEF", "2019-09-21");
        verify(flightStorage, times(20)).add(anyObject());
    }
}