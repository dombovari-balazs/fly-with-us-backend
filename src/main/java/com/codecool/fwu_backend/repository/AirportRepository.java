package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
