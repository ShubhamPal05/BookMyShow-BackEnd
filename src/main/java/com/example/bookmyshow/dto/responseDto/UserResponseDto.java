package com.example.bookmyshow.dto.responseDto;

import java.util.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
    
    private int id;
    private String name;
    private String mobileNo;

    private List<TicketResponseDto> tickets;
}
