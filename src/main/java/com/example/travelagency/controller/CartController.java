package com.example.travelagency.controller;

import com.example.travelagency.domain.*;
import com.example.travelagency.exception.CartNotFoundException;
import com.example.travelagency.exception.ClientNotFoundException;
import com.example.travelagency.exception.TravelNotFoundException;
import com.example.travelagency.exception.TypeNotFoundException;
import com.example.travelagency.mapper.CartMapper;
import com.example.travelagency.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getCarts")
    public List<CartDto> getCarts(){
        List<Cart> carts = cartService.getAllCarts();
        return cartMapper.mapToCartDtoList(carts);
    }

    @RequestMapping(method = RequestMethod.GET,value = "getCart")
    public CartDto getCart(@RequestParam Long cartId)throws CartNotFoundException {
        return cartMapper.mapToCartDto(
                cartService.getCart(cartId).orElseThrow(CartNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.POST,value = "createCart",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto)throws ClientNotFoundException,TravelNotFoundException {
        Cart cart = cartMapper.mapToCart(cartDto);
        cartService.saveCart(cart);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "updateCart",consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartDto updateCart(@RequestBody CartDto cartDto)throws ClientNotFoundException,TravelNotFoundException{
        Cart cart = cartMapper.mapToCart(cartDto);
        Cart savedCart = cartService.saveCart(cart);
        return cartMapper.mapToCartDto(savedCart);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "deleteCart")
    public void deleteCart(@RequestParam Long cartId){
        cartService.deleteCart(cartId);
    }
}
