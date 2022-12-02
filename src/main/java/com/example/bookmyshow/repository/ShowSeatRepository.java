package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.ShowSeatEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity, Integer> {
    
}
