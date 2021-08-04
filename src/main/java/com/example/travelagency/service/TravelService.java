package com.example.travelagency.service;

import com.example.travelagency.domain.Travel;
import com.example.travelagency.repository.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TravelService {

    @Autowired
    private final TravelRepository travelRepository;

    public List<Travel> getAllTravels(){
        return travelRepository.findAll();
    }

    public Optional<Travel> getTravel(final Long travelId){
        return travelRepository.findById(travelId);
    }
    public Travel saveTravel(final Travel travel){
        return travelRepository.save(travel);
    }

    public void deleteTravel(final Long travelId){
        travelRepository.deleteById(travelId);
    }
}
