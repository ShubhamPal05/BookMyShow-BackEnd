package com.example.bookmyshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.bookmyshow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "show_seats")
@Entity
public class ShowSeatEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Doubt
    @Enumerated(EnumType.STRING)
    @Column( name = "seat_type")
    private SeatType seatType;

    @Column( name = "is_Booked", columnDefinition = "bit(1) defalult 0")
    private boolean isBooked;

    @Column (name = "price")
    private double price;

    @Column (name = "seat_number")
    private String seatNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "booked_at")
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;

}
