package com.example.bookmyshow.dto.responseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    
    int id;

    String alloted_seats;

    double amount;

    ShowResponseDto showDto;

    UserResponseDto userDto;
    
}
