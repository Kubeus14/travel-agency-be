package com.example.travelagency.domain;

import com.example.travelagency.repository.TravelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TravelTestSuite {

    @Autowired
    private TravelRepository travelRepository;
    private static final String TEST = "Test Travel";
    @Test
    void testTravel(){
        //Given
        Travel travel = new Travel();
        //When
        travelRepository.save(travel);
        //Then
        Long travelId = travel.getTravelId();
        Optional<Travel> testTravel = travelRepository.findById(travelId);
        assertTrue(testTravel.isPresent());
        //CleanUp
        travelRepository.deleteById(travelId);
    }
    @Test
    void testSaveTravel(){
        //Given
        Travel travel = new Travel();
        //When
        travelRepository.save(travel);
        Long travelId = travel.getTravelId();
        //Then
        assertNotEquals(0L,travelId);
        //CleanUp
        travelRepository.deleteById(travelId);
    }
    @Test
    void testFindAllTravels(){
        //Given
        Travel travel1 = new Travel();
        Travel travel2 = new Travel();
        Travel travel3 = new Travel();
        //When
        travelRepository.save(travel1);
        Long travelOneId = travel1.getTravelId();
        travelRepository.save(travel2);
        Long travelTwoId = travel2.getTravelId();
        travelRepository.save(travel3);
        Long travelThreeId = travel3.getTravelId();
        //Then
        assertEquals(3,travelRepository.findAll().size());
        //CleanUp
        travelRepository.deleteById(travelOneId);
        travelRepository.deleteById(travelTwoId);
        travelRepository.deleteById(travelThreeId);
    }



}
