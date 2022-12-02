package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.TicketEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer>{
    
}
