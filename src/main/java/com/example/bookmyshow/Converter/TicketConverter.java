package com.example.bookmyshow.Converter;

import com.example.bookmyshow.dto.responseDto.TicketResponseDto;
import com.example.bookmyshow.model.ShowSeatEntity;
import com.example.bookmyshow.model.TicketEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    
    public static TicketResponseDto ticketEntityToDto(TicketEntity ticketEntity){

        return TicketResponseDto.builder()
                        .id(ticketEntity.getId())
                        .amount(ticketEntity.getAmount())
                        .alloted_seats(alloted_seats(ticketEntity))
                        .build();
    }

    public String alloted_seats (TicketEntity ticketEntity){
        String str = "";
        for(ShowSeatEntity i: ticketEntity.getSeats()){
            str += i.getSeatNo();
        }
        return str;
    }

}
