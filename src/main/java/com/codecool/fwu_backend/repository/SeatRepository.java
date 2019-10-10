package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Flight;
import com.codecool.fwu_backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query("SELECT s FROM Seat s WHERE s.user = null and s.flight = ?1")
    List<Seat> listAllAvailableSeatByFlightId(Flight flight);
}
