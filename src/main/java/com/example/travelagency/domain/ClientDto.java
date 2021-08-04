package com.example.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class ClientDto {

    private Long clientId;
    private String name;
    private String surname;
    private LocalDate accountDate;
}
