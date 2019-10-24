package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.repository.TravelAgentStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TravelAgentService {
    private TravelAgentStorage agentStorage;

    public List<Flight> listFlightsByAgents(){

    }
}
