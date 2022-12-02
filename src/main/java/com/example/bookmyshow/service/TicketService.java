package com.example.bookmyshow.service;

import com.example.bookmyshow.dto.entryDto.TicketEntryDto;
import com.example.bookmyshow.dto.responseDto.TicketResponseDto;

public interface TicketService {

    public TicketResponseDto bookTicket(TicketEntryDto ticketEntryDto);

    public TicketResponseDto getTicket(int id);
}
