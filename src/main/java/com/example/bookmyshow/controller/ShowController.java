package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entryDto.ShowEntryDto;
import com.example.bookmyshow.dto.responseDto.ShowResponseDto;
import com.example.bookmyshow.service.impl.ShowServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowServiceImpl showServiceImpl;

    @PostMapping("add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){

        return showServiceImpl.addShow(showEntryDto);
    }

    @GetMapping("get/id")
    public ShowResponseDto getShow(@RequestParam("id") int id){
        return showServiceImpl.getShow(id);
    }

}
