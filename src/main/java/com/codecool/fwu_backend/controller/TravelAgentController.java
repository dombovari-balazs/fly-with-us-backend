package com.codecool.fwu_backend.controller;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.TravelAgent;
import com.codecool.fwu_backend.service.TravelAgentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/agents")
@AllArgsConstructor
public class TravelAgentController {
    private TravelAgentService travelAgentService;

    @GetMapping("list")
    public List<TravelAgent> listTravelAgents(){
        return travelAgentService.listTravelAgents();
    }

    @PostMapping("list")
    public List<Flight> listFlightByAgent(@RequestBody String agent){
        return travelAgentService.listFlightByAgent(agent);
    }
}
