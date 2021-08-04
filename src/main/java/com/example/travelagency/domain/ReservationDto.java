package com.example.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class ReservationDto {

    private Long reservationId;
    private LocalDate reservationDate;
}
