package com.example.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class TravelDto {

    private Long travelId;
    private String travelName;
    private String travelDescritpion;
    private LocalDate travelStartDate;
    private LocalDate travelEndDate;
    private BigDecimal price;

}
