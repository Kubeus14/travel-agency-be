package com.example.travelagency.mapper;

import com.example.travelagency.domain.Travel;
import com.example.travelagency.domain.Type;
import com.example.travelagency.domain.TypeDto;
import com.example.travelagency.exception.TravelNotFoundException;
import com.example.travelagency.service.TravelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeMapper {

    private final TravelService travelService;

    public TypeMapper(TravelService travelService) {
        this.travelService = travelService;
    }

    public Type mapToType(final TypeDto typeDto)throws TravelNotFoundException{
        List<Travel> travels = (List<Travel>) travelService.getTravel(typeDto.getTypeId()).orElseThrow(TravelNotFoundException::new);
        return new Type(
                typeDto.getTypeId(),
                typeDto.getTypeName(),
                travels
        );
    }
    public TypeDto mapToTypeDto(final Type type){
        return new TypeDto(
                type.getTypeId(),
                type.getTypeName()
        );
    }
    public List<TypeDto> mapToTypeDtoList(final List<Type> typeList){
        return typeList.stream()
                .map(this::mapToTypeDto)
                .collect(Collectors.toList());
    }



}
