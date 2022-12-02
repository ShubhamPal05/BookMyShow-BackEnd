package com.example.bookmyshow.dto.responseDto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.bookmyshow.model.MovieEntity;
import com.example.bookmyshow.model.TheatreEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowResponseDto {
    
    private int id;
    private LocalDate date;
    private LocalTime time;
    private TheatreEntity theatre;
    private MovieEntity movie;
}
