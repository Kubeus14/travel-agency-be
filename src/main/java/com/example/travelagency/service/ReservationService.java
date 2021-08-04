package com.example.travelagency.service;

import com.example.travelagency.domain.Reservation;
import com.example.travelagency.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }
    public Optional<Reservation> getReservation(final Long reservationId){
        return reservationRepository.findById(reservationId);
    }
    public Reservation saveReservation(final Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public void deleteReservation(final Long reservationId){
        reservationRepository.deleteById(reservationId);
    }
}
