package com.codecool.fwu_backend.repository;

import com.codecool.fwu_backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieStorage extends JpaRepository<Movie, Long> {
    public List<Movie> getMoviesByTitleContains(String string);
}
