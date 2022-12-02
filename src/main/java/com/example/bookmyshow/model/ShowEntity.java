package com.example.bookmyshow.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "shows")
@Entity
public class ShowEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date")
    private LocalDate ShowDate;

    @Column(name = "show_time")
    private LocalTime showTime;

    @OneToMany(mappedBy = "show" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatEntity> showSeatEntity;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheatreEntity theatre;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private MovieEntity movie;
}