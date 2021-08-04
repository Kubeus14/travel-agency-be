package com.example.travelagency.domain;

import com.example.travelagency.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientTestSuite {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void testClient(){
        //Given
        Client client = new Client();
        //When
        clientRepository.save(client);
        //Then
        Long clientId = client.getClientId();
        Optional<Client> testClient = clientRepository.findById(clientId);
        assertTrue(testClient.isPresent());
        //Clean
        clientRepository.deleteById(clientId);
    }
    @Test
    void testFindAllClients(){
        //Given
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        //When
        clientRepository.save(client1);
        Long clientOneId = client1.getClientId();
        clientRepository.save(client2);
        Long clientTwoId = client2.getClientId();
        clientRepository.save(client3);
        Long clientThreeId = client3.getClientId();
        //Then
        assertEquals(3,clientRepository.findAll().size());
        //CleanUp
        clientRepository.deleteById(clientOneId);
        clientRepository.deleteById(clientTwoId);
        clientRepository.deleteById(clientThreeId);
    }


}
