package com.example.travelagency.domain;

import com.example.travelagency.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReservationTestSuite {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void testReservation(){
        //Given
        Reservation reservation = new Reservation();
        //When
        reservationRepository.save(reservation);
        //Then
        Long reservationId = reservation.getReservationId();
        Optional<Reservation> resultTest = reservationRepository.findById(reservationId);
        assertTrue(resultTest.isPresent());
        //CleanUp
        reservationRepository.deleteById(reservationId);
    }
    @Test
    void saveReservation(){
        //Given
        Reservation reservation = new Reservation();
        //When
        reservationRepository.save(reservation);
        Long reservationId = reservation.getReservationId();
        //Then
        assertNotEquals(0L,reservationId);
        //CleanUp
        reservationRepository.deleteById(reservationId);
    }
    @Test
    void findAllReservations(){
        //Given
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        Reservation reservation3 = new Reservation();
        //When
        reservationRepository.save(reservation1);
        Long resOneId = reservation1.getReservationId();
        reservationRepository.save(reservation2);
        Long resSecondId = reservation2.getReservationId();
        reservationRepository.save(reservation3);
        Long resThreeId = reservation3.getReservationId();
        //Then
        assertEquals(3,reservationRepository.findAll().size());
        //CleanUp
        reservationRepository.deleteById(resOneId);
        reservationRepository.deleteById(resSecondId);
        reservationRepository.deleteById(resThreeId);
    }
}
