package com.example.bookmyshow.dto.entryDto;

import java.util.*;

import com.example.bookmyshow.enums.SeatType;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TicketEntryDto {
    
    Set<String> requestedSeats; //User will give

     //user Id who is booking the ticket   :- UserEntity

    int showId; //For which show I want to book ticket :- showEntity

    int UserId; //userId

    SeatType seatType; //TheaterSeatEntity
}