package com.example.bookmyshow.Converter;

import com.example.bookmyshow.dto.entryDto.UserEntryDto;
import com.example.bookmyshow.dto.responseDto.TicketResponseDto;
import com.example.bookmyshow.dto.responseDto.UserResponseDto;
import com.example.bookmyshow.model.TicketEntity;
import com.example.bookmyshow.model.UserEntity;
import java.util.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    
    public static UserEntity userDtoToEntity ( UserEntryDto userEntryDto){
        return UserEntity.builder()
                .name(userEntryDto.getName())
                .mobileNo(userEntryDto.getMobileNo())
                .build();
    }

    public static UserResponseDto userEntityToDto( UserEntity userEntity){

        //trying to convertn TicketEntity to ticketResponseDto and add it into userResposneDto

        
        // List<TicketEntity> tickets = userEntity.getTickets();
        // List<TicketResponseDto> ticketResponseDtos = new ArrayList<>();
        // for(TicketEntity i: tickets){
            
        // }

        return UserResponseDto.builder()
                    .name(userEntity.getName())
                    .mobileNo(userEntity.getMobileNo())
                    .id(userEntity.getId())
                    .build();
    }
}
