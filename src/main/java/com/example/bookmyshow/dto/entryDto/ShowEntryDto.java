package com.example.bookmyshow.dto.entryDto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.bookmyshow.dto.responseDto.MovieResponseDto;
import com.example.bookmyshow.dto.responseDto.TheatreResponseDto;
//import com.example.bookmyshow.repository.MovieRepository;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowEntryDto {
    private LocalDate showDate;

    private LocalTime showTime;

    // private MovieEntryDto movieEntryDto;
    private MovieResponseDto movieResponseDto;

    private TheatreResponseDto theatreResponseDto;

}
