package com.example.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CLIENT")
public class Client {

    private Long clientId;
    private String name;
    private String surname;
    private LocalDate accountDate;
    private Cart cart;
    private List<Reservation> reservations = new ArrayList<>();
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="CLIENT_ID")
    public Long getClientId() {
        return clientId;
    }
    @Column(name="NAME")
    public String getName() {
        return name;
    }
    @Column(name="SURNAME")
    public String getSurname() {
        return surname;
    }
    @Column(name="ACCOUNT_DATE")
    public LocalDate getAccountDate() {
        return accountDate;
    }
    @OneToOne(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="CART_ID")
    public Cart getCart() {
        return cart;
    }
    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAccountDate(LocalDate accountDate) {
        this.accountDate = accountDate;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
