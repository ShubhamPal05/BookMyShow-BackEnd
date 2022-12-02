package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entryDto.TheatreEntryDto;
import com.example.bookmyshow.dto.responseDto.TheatreResponseDto;

public interface TheatreService {
    
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);

    public TheatreResponseDto getTheatre(int id);
}