package com.example.travelagency.controller;

import com.example.travelagency.domain.Reservation;
import com.example.travelagency.domain.ReservationDto;
import com.example.travelagency.exception.ClientNotFoundException;
import com.example.travelagency.exception.ReservationNotFoundException;
import com.example.travelagency.mapper.ReservationMapper;
import com.example.travelagency.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getReservations")
    public List<ReservationDto> getReservations(){
        List<Reservation> reservations = reservationService.getAllReservations();
        return reservationMapper.mapToReservationDtoList(reservations);
    }
    @RequestMapping(method = RequestMethod.GET,value = "getReservation")
    public ReservationDto getReservation(@RequestParam Long reservationId)throws ReservationNotFoundException {
        return reservationMapper.mapToReservationDto(
                reservationService.getReservation(reservationId).orElseThrow(ReservationNotFoundException::new)
        );
    }
    @RequestMapping(method = RequestMethod.POST,value = "createReservation",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReservation(@RequestBody ReservationDto reservationDto)throws ClientNotFoundException {
        Reservation reservation = reservationMapper.mapToReservation(reservationDto);
        reservationService.saveReservation(reservation);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "updateReservation")
    public ReservationDto updateReservation(@RequestBody ReservationDto reservationDto)throws ClientNotFoundException{
        Reservation reservation = reservationMapper.mapToReservation(reservationDto);
        Reservation savedReservation = reservationService.saveReservation(reservation);
        return reservationMapper.mapToReservationDto(savedReservation);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteReservation")
    public void deleteReservation(@RequestParam Long reservationId){
        reservationService.deleteReservation(reservationId);
    }
}
