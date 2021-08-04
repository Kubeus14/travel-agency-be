package com.example.travelagency.controller;

import com.example.travelagency.domain.Type;
import com.example.travelagency.domain.TypeDto;
import com.example.travelagency.exception.TravelNotFoundException;
import com.example.travelagency.exception.TypeNotFoundException;
import com.example.travelagency.mapper.TypeMapper;
import com.example.travelagency.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/type")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;
    private final TypeMapper typeMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getTypes")
    public List<TypeDto> getTypes(){
        List<Type> types = typeService.getAllTypes();
        return typeMapper.mapToTypeDtoList(types);
    }
    @RequestMapping(method = RequestMethod.GET,value = "getType")
    public TypeDto getType(@RequestParam Long typeId)throws TypeNotFoundException{
        return typeMapper.mapToTypeDto(
                typeService.getType(typeId).orElseThrow(TypeNotFoundException::new)
        );
    }
    @RequestMapping(method = RequestMethod.POST,value = "createType",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createType(@RequestBody TypeDto typeDto)throws TravelNotFoundException {
        typeService.saveType(typeMapper.mapToType(typeDto));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "deleteType")
    public void deleteType(@RequestParam Long typeId){
        typeService.deleteType(typeId);
    }
}
