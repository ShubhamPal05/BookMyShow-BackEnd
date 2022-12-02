package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.MovieEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository< MovieEntity, Integer> {

    boolean existsByName(String name);

    MovieEntity findByName(String name);
}