package com.example.travelagency.repository;

import com.example.travelagency.domain.Travel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TravelRepository extends CrudRepository<Travel,Long> {

    @Override
    List<Travel> findAll();

    @Override
    Optional<Travel> findById(Long id);

    @Override
    Travel save(Travel travel);

    @Override
    void deleteById(Long id);
}
