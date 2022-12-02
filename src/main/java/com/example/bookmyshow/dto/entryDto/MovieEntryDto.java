package com.example.bookmyshow.dto.entryDto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MovieEntryDto {
    private String name;
    private LocalDate releaseDate;
}
