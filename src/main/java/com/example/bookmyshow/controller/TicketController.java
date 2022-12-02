package com.example.bookmyshow.controller;

import javax.websocket.server.PathParam;

import com.example.bookmyshow.dto.entryDto.TicketEntryDto;
import com.example.bookmyshow.dto.responseDto.TicketResponseDto;
import com.example.bookmyshow.service.impl.TicketServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {
    
    @Autowired
    TicketServiceImpl ticketServiceImpl;

    @PostMapping("bookTicket")
    public TicketResponseDto addTicket(@RequestBody() TicketEntryDto ticketEntryDto){

        return ticketServiceImpl.bookTicket(ticketEntryDto);
    }

    @GetMapping("get")
    public TicketResponseDto getTicket(@PathParam("id") int id){

        return ticketServiceImpl.getTicket(id);
    }
}
