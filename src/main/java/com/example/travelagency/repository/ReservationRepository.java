package com.example.travelagency.repository;

import com.example.travelagency.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {

    @Override
    List<Reservation> findAll();

    @Override
    Optional<Reservation> findById(Long id);

    @Override
    Reservation save(Reservation reservation);

    @Override
    void deleteById(Long id);

}
