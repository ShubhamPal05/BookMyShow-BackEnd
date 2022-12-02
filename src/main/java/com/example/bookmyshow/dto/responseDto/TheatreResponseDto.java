package com.example.bookmyshow.dto.responseDto;

import java.util.*;
import com.example.bookmyshow.enums.TheatreType;
import com.example.bookmyshow.model.ShowEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDto {
    private int id;
    private String theatreName;
    private String city;
    private TheatreType theatreType;
    
    private List<ShowEntity> shows;
}
