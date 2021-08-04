package com.example.travelagency.controller;

import com.example.travelagency.domain.Client;
import com.example.travelagency.domain.ClientDto;
import com.example.travelagency.exception.CartNotFoundException;
import com.example.travelagency.exception.ClientNotFoundException;
import com.example.travelagency.exception.ReservationNotFoundException;
import com.example.travelagency.mapper.ClientMapper;
import com.example.travelagency.service.CartService;
import com.example.travelagency.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getClients")
    public List<ClientDto> getClients(){
        List<Client> clients = clientService.getAllClients();
        return clientMapper.mapToClientDtoList(clients);
    }

    @RequestMapping(method = RequestMethod.GET,value = "getClient")
    public ClientDto getClient(@RequestParam Long clientId)throws ClientNotFoundException {
        return clientMapper.mapToClientDto(
                clientService.getClient(clientId).orElseThrow(ClientNotFoundException::new)
        );

    }

    @RequestMapping(method = RequestMethod.POST,value = "createClient",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody ClientDto clientDto)throws CartNotFoundException, ReservationNotFoundException {
        Client client = clientMapper.mapToClient(clientDto);
        clientService.saveClient(client);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "deleteClient")
    public void deleteClient(@RequestParam Long clientId) {
        clientService.deleteClient(clientId);
    }

}
