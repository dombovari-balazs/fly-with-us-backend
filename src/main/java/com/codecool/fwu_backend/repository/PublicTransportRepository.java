package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.PublicTransport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PublicTransportRepository extends JpaRepository<PublicTransport, Long> {
}
