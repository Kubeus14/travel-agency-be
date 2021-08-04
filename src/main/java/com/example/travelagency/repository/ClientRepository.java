package com.example.travelagency.repository;

import com.example.travelagency.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {

    @Override
    List<Client> findAll();

    @Override
    Optional<Client> findById(Long id);

    @Override
    Client save(Client client);

    @Override
    void deleteById(Long id);
}
