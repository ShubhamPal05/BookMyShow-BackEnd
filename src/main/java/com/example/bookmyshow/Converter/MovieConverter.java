package com.example.bookmyshow.Converter;

import com.example.bookmyshow.dto.entryDto.MovieEntryDto;
import com.example.bookmyshow.dto.responseDto.MovieResponseDto;
import com.example.bookmyshow.model.MovieEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {
    
    public static MovieEntity movieDtotoEntity (MovieEntryDto movieEntryDto){
        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate())
                .build();
    }

    public static MovieResponseDto movieEntityToDto (MovieEntity movieEntity){

        return MovieResponseDto.builder()
                        .id(movieEntity.getId())
                        .name(movieEntity.getName())
                        .releaseDate(movieEntity.getReleaseDate())
                        .build();
    }

}
