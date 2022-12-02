package com.example.bookmyshow.service.impl;

import com.example.bookmyshow.Converter.ShowConverter;
import com.example.bookmyshow.dto.entryDto.ShowEntryDto;
import com.example.bookmyshow.dto.responseDto.ShowResponseDto;
import com.example.bookmyshow.model.ShowEntity;
import com.example.bookmyshow.model.ShowSeatEntity;
import com.example.bookmyshow.model.TheatreSeatEntity;
import com.example.bookmyshow.repository.MovieRepository;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.ShowSeatRepository;
import com.example.bookmyshow.repository.TheatreRepository;
import com.example.bookmyshow.service.ShowService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity = ShowConverter.showDtotoEntity(showEntryDto);

        //showEntity.setMovie(movieRepository.findByName(showEntryDto.getMovieEntryDto().getName()));
        showEntity.setMovie(movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get());

        showEntity.setTheatre(theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get());


        List<TheatreSeatEntity> theatreSeats = theatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get().getSeats();

        showEntity = showRepository.save(showEntity);

        List<ShowSeatEntity> showSeatEntity = generateShowSeatsList(theatreSeats, showEntity);

        showEntity.setShowSeatEntity(showSeatEntity);

        return ShowConverter.showEntityToDto(showEntity);
    }

    public List<ShowSeatEntity> generateShowSeatsList(List<TheatreSeatEntity> theatreSeats, ShowEntity showEntity){

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
        for(TheatreSeatEntity i: theatreSeats){
            ShowSeatEntity showSeatEntity = ShowSeatEntity.builder()
                .seatNo(i.getSeatNo())
                .seatType(i.getSeatType())
                .price(i.getRate())
                .build();

            showSeatEntity.setShow(showEntity);
            showSeatEntityList.add(showSeatEntity);
        }

        showSeatRepository.saveAll(showSeatEntityList);
        return showSeatEntityList;
    }

    @Override
    public ShowResponseDto getShow(int id) {

        ShowEntity showEntity = showRepository.findById(id).get();

        return ShowConverter.showEntityToDto(showEntity);
        
    }
    
}
