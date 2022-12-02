package com.example.bookmyshow.Converter;

import com.example.bookmyshow.dto.entryDto.TheatreEntryDto;
import com.example.bookmyshow.dto.responseDto.TheatreResponseDto;
import com.example.bookmyshow.model.TheatreEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {
    
    //converting from TheatreEntryDto to TheatreEntity;
    public static TheatreEntity theatreDtoToEntity (TheatreEntryDto theatreEntryDto){

        return TheatreEntity.builder()
                .theatreName(theatreEntryDto.getTheatreName())
                .theatreType(theatreEntryDto.getTheatreType())
                .city(theatreEntryDto.getCity())
                .build();
    }

    public static TheatreResponseDto theatreEntitytoDto (TheatreEntity theatreEntity){

        TheatreResponseDto theatreResponseDto = TheatreResponseDto.builder()
                                                    .id(theatreEntity.getId())
                                                    .city(theatreEntity.getCity())
                                                    .theatreName(theatreEntity.getTheatreName())
                                                    .theatreType(theatreEntity.getTheatreType())
                                                    .shows(theatreEntity.getShows())
                                                    .build();


        return theatreResponseDto;
    }
}