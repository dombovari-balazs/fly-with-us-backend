package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableFlightStorage extends JpaRepository<Flight, Long> {
}
