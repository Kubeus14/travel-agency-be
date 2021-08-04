package com.example.travelagency.domain;

import com.example.travelagency.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CartTestSuite {
    @Autowired
    private CartRepository cartRepository;
    @Test
    void testCart(){
        //Given
        Cart cart = new Cart();
        //When
        cartRepository.save(cart);
        //Then
        Long cartId = cart.getCartId();
        Optional<Cart> testCart = cartRepository.findById(cartId);
        assertTrue(testCart.isPresent());
        //CleanUp
        cartRepository.deleteById(cartId);
    }
    @Test
    void testSaveCart(){
        //Given
        Cart cart = new Cart();
        //When
        cartRepository.save(cart);
        Long id = cart.getCartId();
        //Then
        assertNotEquals(0L,id);
        //CleanUp
        cartRepository.deleteById(id);
    }
    @Test
    void testFindAllCarts(){
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        //When
        cartRepository.save(cart1);
        Long cartOneId = cart1.getCartId();
        cartRepository.save(cart2);
        Long cartSecondId = cart2.getCartId();
        //Then
        assertEquals(2,cartRepository.findAll().size());
        //CleanUp
        cartRepository.deleteById(cartOneId);
        cartRepository.deleteById(cartSecondId);

    }
}
