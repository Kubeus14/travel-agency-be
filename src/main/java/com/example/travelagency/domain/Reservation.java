package com.example.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "RESERVATION")
public class Reservation {

    private Long reservationId;
    private LocalDate reservationDate;
    private Client client;
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "RESERVATION_ID")
    public Long getReservationId() {
        return reservationId;
    }
    @Column(name = "RESERVATION_DATE")
    public LocalDate getReservationDate() {
        return reservationDate;
    }
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    public Client getClient() {
        return client;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
