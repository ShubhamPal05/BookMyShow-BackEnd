package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entryDto.MovieEntryDto;
import com.example.bookmyshow.dto.responseDto.MovieResponseDto;

public interface MovieService {
    
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto);
    
    public MovieResponseDto getMovie(int id);
}