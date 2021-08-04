package com.example.travelagency.service;

import com.example.travelagency.domain.Cart;
import com.example.travelagency.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    @Autowired
    private final CartRepository cartRepository;

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }
    public Optional<Cart> getCart(final Long cartId){
        return cartRepository.findById(cartId);
    }
    public Cart saveCart(final Cart cart){
        return cartRepository.save(cart);
    }
    public void deleteCart(final Long cartId){
        cartRepository.deleteById(cartId);
    }
}
