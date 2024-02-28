package com.example.AllinOne.Repository;

import com.example.AllinOne.Entity.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
