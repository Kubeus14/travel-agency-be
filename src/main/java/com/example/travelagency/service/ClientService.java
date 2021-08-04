package com.example.travelagency.service;

import com.example.travelagency.domain.Client;
import com.example.travelagency.domain.ClientDto;
import com.example.travelagency.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(final Long clientId){
        return clientRepository.findById(clientId);
    }

    public Client saveClient(final Client client){
        return clientRepository.save(client);
    }

    public void deleteClient(final Long clientId){
        clientRepository.deleteById(clientId);
    }

}
