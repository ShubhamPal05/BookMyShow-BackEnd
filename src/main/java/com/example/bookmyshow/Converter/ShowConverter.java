package com.example.bookmyshow.Converter;

import com.example.bookmyshow.dto.entryDto.ShowEntryDto;
import com.example.bookmyshow.dto.responseDto.ShowResponseDto;
import com.example.bookmyshow.model.ShowEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    
    public static ShowEntity showDtotoEntity (ShowEntryDto showEntryDto){
        return ShowEntity.builder()
                .ShowDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime())
                .build();
    }

    public static ShowResponseDto showEntityToDto (ShowEntity showEntity){
        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .date(showEntity.getShowDate())
                .time(showEntity.getShowTime())
                .theatre(showEntity.getTheatre())
                .movie(showEntity.getMovie())
                .build();
    }
}
