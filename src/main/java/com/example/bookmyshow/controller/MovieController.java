package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entryDto.MovieEntryDto;
import com.example.bookmyshow.dto.responseDto.MovieResponseDto;
import com.example.bookmyshow.service.impl.MovieServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {
    
    @Autowired
    MovieServiceImpl movieServiceImpl;

    @PostMapping("add-movie")
    public MovieResponseDto addMovie(@RequestBody() MovieEntryDto movieEntryDto){

        return movieServiceImpl.addMovie(movieEntryDto);
    }

    @GetMapping("/get/{id}")
    public MovieResponseDto getMovie(@PathVariable("id") int id){
        return movieServiceImpl.getMovie(id);
    }
}
