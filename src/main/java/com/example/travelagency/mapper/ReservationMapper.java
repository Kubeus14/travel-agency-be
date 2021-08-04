package com.example.travelagency.mapper;

import com.example.travelagency.domain.Client;
import com.example.travelagency.domain.Reservation;
import com.example.travelagency.domain.ReservationDto;
import com.example.travelagency.exception.ClientNotFoundException;
import com.example.travelagency.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationMapper {

    private final ClientService clientService;

    public Reservation mapToReservation(final ReservationDto reservationDto)throws ClientNotFoundException{
        Client client = clientService.getClient(reservationDto.getReservationId()).orElseThrow(ClientNotFoundException::new);
        return new Reservation(
                reservationDto.getReservationId(),
                reservationDto.getReservationDate(),
                client
        );
    }
    public ReservationDto mapToReservationDto(final Reservation reservation){
        return new ReservationDto(
                reservation.getReservationId(),
                reservation.getReservationDate()
        );
    }
    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservationList){
        return reservationList.stream()
                .map(this::mapToReservationDto)
                .collect(Collectors.toList());
    }
}
