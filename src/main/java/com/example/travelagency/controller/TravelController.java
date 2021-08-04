package com.example.travelagency.controller;

import com.example.travelagency.domain.Travel;
import com.example.travelagency.domain.TravelDto;
import com.example.travelagency.exception.CartNotFoundException;
import com.example.travelagency.exception.ReservationNotFoundException;
import com.example.travelagency.exception.TravelNotFoundException;
import com.example.travelagency.exception.TypeNotFoundException;
import com.example.travelagency.mapper.TravelMapper;
import com.example.travelagency.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/travel")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService travelService;
    private final TravelMapper travelMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getTravels")
    public List<TravelDto> getTravels(){
        List<Travel> travels = travelService.getAllTravels();
        return travelMapper.mapToTravelDtoList(travels);
    }
    @RequestMapping(method = RequestMethod.GET,value = "getTravel")
    public TravelDto getTravel(@RequestParam Long travelId)throws TravelNotFoundException {
        return travelMapper.mapToTravelDto(
                travelService.getTravel(travelId).orElseThrow(TravelNotFoundException::new)
        );
    }
    @RequestMapping(method = RequestMethod.POST,value = "createTravel",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTravel(@RequestBody TravelDto travelDto) throws TypeNotFoundException, CartNotFoundException, ReservationNotFoundException {
        Travel travel = travelMapper.mapToTravel(travelDto);
        travelService.saveTravel(travel);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "deleteTravel")
    public void deleteTravel(@RequestParam Long travelId){
        travelService.deleteTravel(travelId);
    }
}
