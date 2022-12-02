package com.example.bookmyshow.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.bookmyshow.Converter.TicketConverter;
import com.example.bookmyshow.dto.entryDto.TicketEntryDto;
import com.example.bookmyshow.dto.responseDto.TicketResponseDto;
import com.example.bookmyshow.model.ShowEntity;
import com.example.bookmyshow.model.ShowSeatEntity;
import com.example.bookmyshow.model.TicketEntity;
import com.example.bookmyshow.model.UserEntity;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.TicketRepository;
import com.example.bookmyshow.repository.UserRepository;
import com.example.bookmyshow.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;


    @Override
    public TicketResponseDto bookTicket(TicketEntryDto ticketEntryDto) {
        UserEntity userEntity = userRepository.findById(ticketEntryDto.getUserId()).get();

        ShowEntity showEntity = showRepository.findById(ticketEntryDto.getShowId()).get();

        Set<String> requestSeats = ticketEntryDto.getRequestedSeats();

        List<ShowSeatEntity> showSeatEntity = showEntity.getShowSeatEntity();

        List<ShowSeatEntity> bookedSeats = showSeatEntity.stream()
            .filter(seats -> !seats.isBooked() &&
                            seats.getSeatType().equals(ticketEntryDto.getSeatType()) &&
                            requestSeats.contains(seats.getSeatNo()))
            .collect(Collectors.toList());

        if(bookedSeats.size() != requestSeats.size()){
            throw new Error("all seats not available !");
        }

        TicketEntity ticketEntity = TicketEntity.builder()
                                    .seats(bookedSeats)
                                    .user(userEntity)
                                    .show(showEntity)
                                    .build();

        Double amount = 0d;

        for(ShowSeatEntity i: bookedSeats){
            amount += i.getPrice();
            i.setBookedAt(new Date());
            i.setBooked(true);
            i.setTicket(ticketEntity);
        }

        ticketEntity.setAmount(amount);
        ticketEntity.setCreatedAt(new Date());
        ticketEntity.setUpdatedAt(new Date());

        userEntity.getTickets().add(ticketEntity);

        ticketEntity = ticketRepository.save(ticketEntity);

        return TicketConverter.ticketEntityToDto(ticketEntity);
    }

    @Override
    public TicketResponseDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        return TicketConverter.ticketEntityToDto(ticketEntity);
    }

}
