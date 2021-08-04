package com.example.travelagency.mapper;

import com.example.travelagency.domain.Cart;
import com.example.travelagency.domain.CartDto;
import com.example.travelagency.domain.Client;
import com.example.travelagency.domain.Travel;
import com.example.travelagency.exception.ClientNotFoundException;
import com.example.travelagency.exception.TravelNotFoundException;
import com.example.travelagency.service.ClientService;
import com.example.travelagency.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartMapper {

    private final ClientService clientService;
    private final TravelService travelService;

    public Cart mapToCart(final CartDto cartDto)throws ClientNotFoundException, TravelNotFoundException {
        Client client = clientService.getClient(cartDto.getCartId()).orElseThrow(ClientNotFoundException::new);
        List<Travel> travels = (List<Travel>) travelService.getTravel(cartDto.getCartId()).orElseThrow(TravelNotFoundException::new);
        return new Cart(
                cartDto.getCartId(),
                client,
                travels
        );
    }
    public CartDto mapToCartDto(final Cart cart){
        return new CartDto(
                cart.getCartId()
        );
    }
    public List<CartDto> mapToCartDtoList(final List<Cart> cartList){
        return cartList.stream()
                .map(this::mapToCartDto)
                .collect(Collectors.toList());
    }
}
