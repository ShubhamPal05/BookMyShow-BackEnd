package com.example.bookmyshow.service.impl;

import com.example.bookmyshow.Converter.UserConverter;
import com.example.bookmyshow.dto.entryDto.UserEntryDto;
import com.example.bookmyshow.dto.responseDto.UserResponseDto;
import com.example.bookmyshow.model.UserEntity;
import com.example.bookmyshow.repository.TicketRepository;
import com.example.bookmyshow.repository.UserRepository;
import com.example.bookmyshow.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConverter.userDtoToEntity(userEntryDto);

        userEntity = userRepository.save(userEntity);

        return getUser(userEntity.getId());
    }

    @Override
    public UserResponseDto getUser(int id) {

        UserEntity userEntity = userRepository.findById(id).get();

        return UserConverter.userEntityToDto(userEntity);
    }
}