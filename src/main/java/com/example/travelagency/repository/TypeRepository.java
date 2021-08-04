package com.example.travelagency.repository;

import com.example.travelagency.domain.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends CrudRepository<Type,Long> {

    @Override
    List<Type> findAll();

    @Override
    Optional<Type> findById(Long id);

    @Override
    Type save(Type type);

    @Override
    void deleteById(Long id);
}
