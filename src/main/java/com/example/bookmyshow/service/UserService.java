package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entryDto.UserEntryDto;
import com.example.bookmyshow.dto.responseDto.UserResponseDto;

public interface UserService {

    public UserResponseDto addUser(UserEntryDto userEntryDto);

    public UserResponseDto getUser(int id);
}
