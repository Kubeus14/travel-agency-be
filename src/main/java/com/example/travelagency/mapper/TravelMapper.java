package com.example.travelagency.mapper;

import com.example.travelagency.domain.*;
import com.example.travelagency.exception.CartNotFoundException;
import com.example.travelagency.exception.ReservationNotFoundException;
import com.example.travelagency.exception.TravelNotFoundException;
import com.example.travelagency.exception.TypeNotFoundException;
import com.example.travelagency.service.CartService;
import com.example.travelagency.service.ReservationService;
import com.example.travelagency.service.TravelService;
import com.example.travelagency.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelMapper {

    private final TypeService typeService;
    private final CartService cartService;
    private final ReservationService reservationService;

    public Travel mapToTravel(final TravelDto travelDto) throws TypeNotFoundException, CartNotFoundException, ReservationNotFoundException {
        Type type = typeService.getType(travelDto.getTravelId()).orElseThrow(TypeNotFoundException::new);
        List<Cart> carts = (List<Cart>) cartService.getCart(travelDto.getTravelId()).orElseThrow(CartNotFoundException::new);
        Reservation reservation = reservationService.getReservation(travelDto.getTravelId()).orElseThrow(ReservationNotFoundException::new );
        return new Travel(
                travelDto.getTravelId(),
                travelDto.getTravelName(),
                travelDto.getTravelDescritpion(),
                travelDto.getTravelStartDate(),
                travelDto.getTravelEndDate(),
                travelDto.getPrice(),
                type,
                carts,
                reservation
        );
    }
    public TravelDto mapToTravelDto(final Travel travel){
        return new TravelDto(
                travel.getTravelId(),
                travel.getTravelName(),
                travel.getTravelDescritpion(),
                travel.getTravelStartDate(),
                travel.getTravelEndDate(),
                travel.getPrice()

        );
    }
    public List<TravelDto> mapToTravelDtoList(final List<Travel> travelList){
        return travelList.stream()
                .map(this::mapToTravelDto)
                .collect(Collectors.toList());
    }
}
