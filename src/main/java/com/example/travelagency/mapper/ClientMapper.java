package com.example.travelagency.mapper;

import com.example.travelagency.domain.*;
import com.example.travelagency.exception.CartNotFoundException;
import com.example.travelagency.exception.ReservationNotFoundException;
import com.example.travelagency.service.CartService;
import com.example.travelagency.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientMapper {

    private final CartService cartService;
    private final ReservationService reservationService;


    public Client mapToClient(final ClientDto clientDto)throws CartNotFoundException, ReservationNotFoundException {
        Cart cart = cartService.getCart(clientDto.getClientId()).orElseThrow(CartNotFoundException::new);
        List<Reservation> reservations = (List<Reservation>) reservationService.getReservation(clientDto.getClientId()).orElseThrow(ReservationNotFoundException::new);
        return new Client(
                clientDto.getClientId(),
                clientDto.getName(),
                clientDto.getSurname(),
                clientDto.getAccountDate(),
                cart,
                reservations
        );
    }
    public ClientDto mapToClientDto(final Client client){
        return new ClientDto(
                client.getClientId(),
                client.getName(),
                client.getSurname(),
                client.getAccountDate()
        );
    }
    public List<ClientDto> mapToClientDtoList(final List<Client> clientList){
        return clientList.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }


}
