package com.example.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CART")
public class Cart {

    private Long cartId;
    private Client client;
    private List<Travel> travels = new ArrayList<>();
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="CART_ID")
    public Long getCartId() {
        return cartId;
    }
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="CLIENT_ID")
    public Client getClient() {
        return client;
    }
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "carts")
    public List<Travel> getTravels() {
        return travels;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTravels(List<Travel> travels) {
        this.travels = travels;
    }
}
