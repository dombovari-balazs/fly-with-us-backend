package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.TravelAgent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelAgentStorage extends JpaRepository<TravelAgent, Long> {
    public List<TravelAgent> getTravelAgentByFlightsContaining(Flight flight);
}
