package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStorage extends JpaRepository<Movie, Long> {
}
