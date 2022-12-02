package com.example.bookmyshow.service.impl;

import java.util.*;

import com.example.bookmyshow.Converter.TheatreConverter;
import com.example.bookmyshow.dto.entryDto.TheatreEntryDto;
import com.example.bookmyshow.dto.responseDto.TheatreResponseDto;
import com.example.bookmyshow.enums.SeatType;
import com.example.bookmyshow.model.TheatreEntity;
import com.example.bookmyshow.model.TheatreSeatEntity;
import com.example.bookmyshow.repository.TheatreRepository;
import com.example.bookmyshow.repository.TheatreSeatRepository;
import com.example.bookmyshow.service.TheatreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto) {

        TheatreEntity theatreEntity = TheatreConverter.theatreDtoToEntity(theatreEntryDto);

        List<TheatreSeatEntity> seats = new ArrayList<>();

        seats.add( getTheatreSeat("1A", 100d, SeatType.CLASSIC, theatreEntity) );
        seats.add( getTheatreSeat("1B", 100d, SeatType.CLASSIC, theatreEntity) );
        seats.add( getTheatreSeat("1C", 100d, SeatType.CLASSIC, theatreEntity) );
        seats.add( getTheatreSeat("1D", 100d, SeatType.CLASSIC, theatreEntity) );
        seats.add( getTheatreSeat("1E", 100d, SeatType.CLASSIC, theatreEntity) );

        seats.add( getTheatreSeat("2A", 200d, SeatType.PREMIUM, theatreEntity) );
        seats.add( getTheatreSeat("2B", 200d, SeatType.PREMIUM, theatreEntity) );
        seats.add( getTheatreSeat("2C", 200d, SeatType.PREMIUM, theatreEntity) );
        seats.add( getTheatreSeat("2D", 200d, SeatType.PREMIUM, theatreEntity) );
        seats.add( getTheatreSeat("2E", 200d, SeatType.PREMIUM, theatreEntity) );

        theatreEntity.setSeats(seats);

        seats = theatreSeatRepository.saveAll(seats);

        theatreEntity = theatreRepository.save(theatreEntity);

        return TheatreConverter.theatreEntitytoDto(theatreEntity);
    }

    public static TheatreSeatEntity getTheatreSeat(String seatNo, Double rate, SeatType seatType, TheatreEntity theatreEntity ){

        return TheatreSeatEntity.builder()
            .seatNo(seatNo)
            .rate(rate)
            .seatType(seatType)
            .theatre(theatreEntity)
            .build();
    }



    @Override
    public TheatreResponseDto getTheatre(int id) {

        TheatreEntity theatreEntity = theatreRepository.findById(id).get();
        
        return TheatreConverter.theatreEntitytoDto(theatreEntity);
    }
    
}
