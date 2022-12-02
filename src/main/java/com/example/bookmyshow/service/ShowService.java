package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entryDto.ShowEntryDto;
import com.example.bookmyshow.dto.responseDto.ShowResponseDto;

public interface ShowService {
    
    public ShowResponseDto addShow(ShowEntryDto showEntryDto);

    public ShowResponseDto getShow(int id);
    
}