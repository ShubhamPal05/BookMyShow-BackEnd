package com.example.bookmyshow.dto.entryDto;

import com.example.bookmyshow.enums.TheatreType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntryDto {
    
    private String theatreName;
    private String city;
    private TheatreType theatreType;

}
