package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
