package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Table;

@Table(name = "booked_flights")
public interface BookedFlightStorage extends JpaRepository<Flight, Long> {
}
