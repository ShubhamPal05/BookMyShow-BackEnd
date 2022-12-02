package com.example.bookmyshow.service.impl;

import com.example.bookmyshow.Converter.MovieConverter;
import com.example.bookmyshow.dto.entryDto.MovieEntryDto;
import com.example.bookmyshow.dto.responseDto.MovieResponseDto;
import com.example.bookmyshow.model.MovieEntity;
import com.example.bookmyshow.repository.MovieRepository;
import com.example.bookmyshow.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {
        MovieEntity movieEntity = MovieConverter.movieDtotoEntity(movieEntryDto);

        
        if( movieRepository.existsByName(movieEntryDto.getName())){
            log.info("movie already exists !");
            return MovieConverter.movieEntityToDto(movieEntity);
        }

        //on saving to repository id is added;
        movieEntity = movieRepository.save(movieEntity);

        log.info("movie added");
        
        return MovieConverter.movieEntityToDto(movieEntity);
    }

    @Override
    public MovieResponseDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();
        return MovieConverter.movieEntityToDto(movieEntity);
        
    }
    
}
