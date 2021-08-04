package com.example.travelagency.domain;

import com.example.travelagency.repository.TypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TypeTestSuite {

    @Autowired
    private TypeRepository typeRepository;
    @Test
    void testType(){
        //Given
        Type type = new Type();
        //When
        typeRepository.save(type);
        //Then
        Long id = type.getTypeId();
        Optional<Type> testType = typeRepository.findById(id);
        assertTrue(testType.isPresent());
        //CleanUp
        typeRepository.deleteById(id);
    }
    @Test
    void testSaveType(){
        //Given
        Type type = new Type();
        //When
        typeRepository.save(type);
        Long typeId = type.getTypeId();
        //Then
        assertNotEquals(0L,typeId);
        //CleanUp
        typeRepository.deleteById(typeId);
    }

    @Test
    void testFindAllTypes(){
        //Given
        Type type1 = new Type();
        Type type2 = new Type();
        Type type3 = new Type();
        //When
        typeRepository.save(type1);
        Long typeOneId = type1.getTypeId();
        typeRepository.save(type2);
        Long typeSecondId = type2.getTypeId();
        typeRepository.save(type3);
        Long typeThirdId = type3.getTypeId();
        //Then
        assertEquals(3,typeRepository.findAll().size());
        //CleanUp
        typeRepository.deleteById(typeOneId);
        typeRepository.deleteById(typeSecondId);
        typeRepository.deleteById(typeThirdId);
    }
}
