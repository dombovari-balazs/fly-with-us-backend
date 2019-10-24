package com.codecool.fwu_backend.service;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.TravelAgent;
import com.codecool.fwu_backend.repository.AvailableFlightStorage;
import com.codecool.fwu_backend.repository.TravelAgentStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TravelAgentService {
    private TravelAgentStorage agentStorage;
    private AvailableFlightStorage flightStorage;

    public List<TravelAgent> listTravelAgents(){
        return agentStorage.findAll();
    }

    public List<Flight> listFlightByAgent(String agentName){
    return agentStorage.findTravelAgentByName(agentName).getFlights();
    }
}
