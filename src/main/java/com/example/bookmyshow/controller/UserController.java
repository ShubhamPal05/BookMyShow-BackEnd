package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entryDto.UserEntryDto;
import com.example.bookmyshow.dto.responseDto.UserResponseDto;
import com.example.bookmyshow.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("add")
    public UserResponseDto addUser(@RequestBody() UserEntryDto userEntryDto){

        return userServiceImpl.addUser(userEntryDto);
    }

    @GetMapping("get")
    public UserResponseDto getUser (@RequestParam("id") int id){
        
        return userServiceImpl.getUser(id);
    }
}
