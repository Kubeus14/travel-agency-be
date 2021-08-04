package com.example.travelagency.service;

import com.example.travelagency.domain.Type;
import com.example.travelagency.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeService {

    @Autowired
    private final TypeRepository typeRepository;

    public List<Type> getAllTypes(){
        return typeRepository.findAll();
    }

    public Optional<Type> getType(final Long typeId){
        return typeRepository.findById(typeId);
    }

    public Type saveType(final Type type){
        return typeRepository.save(type);
    }

    public void deleteType(final Long typeId){
        typeRepository.deleteById(typeId);
    }
}
