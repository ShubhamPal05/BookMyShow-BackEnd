package com.example.bookmyshow.dto.responseDto;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MovieResponseDto {
    private int id;
    private String name;
    private LocalDate releaseDate;

    private List<ShowResponseDto> shows;
}