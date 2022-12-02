package com.example.bookmyshow.controller;

import javax.websocket.server.PathParam;

import com.example.bookmyshow.dto.entryDto.TheatreEntryDto;
import com.example.bookmyshow.dto.responseDto.TheatreResponseDto;
import com.example.bookmyshow.service.impl.TheatreServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theatre")
public class TheatreController {
    
    @Autowired
    TheatreServiceImpl theatreServiceImpl;

    @PostMapping("add")
    public TheatreResponseDto addTheatre(@RequestBody() TheatreEntryDto theatreEntryDto){

        return theatreServiceImpl.addTheatre(theatreEntryDto);
    }

    @GetMapping("get")
    public TheatreResponseDto getTheatre(@PathParam("id") int id){

        return theatreServiceImpl.getTheatre(id);
    }
}
