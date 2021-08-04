package com.example.travelagency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TRAVEL")
public class Travel {

    private Long travelId;
    private String travelName;
    private String travelDescritpion;
    private LocalDate travelStartDate;
    private LocalDate travelEndDate;
    private BigDecimal price;
    private Type type;
    private List<Cart> carts = new ArrayList<>();
    private Reservation reservation;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="TRAVEL_ID")
    public Long getTravelId() {
        return travelId;
    }
    @Column(name="TRAVEL_NAME")
    public String getTravelName() {
        return travelName;
    }
    @Column(name="TRAVEL_DESCRIPTION")
    public String getTravelDescritpion() {
        return travelDescritpion;
    }
    @Column(name="TRAVEL_START_DATE")
    public LocalDate getTravelStartDate() {
        return travelStartDate;
    }
    @Column(name="TRAVEL_END_DATE")
    public LocalDate getTravelEndDate() {
        return travelEndDate;
    }
    @Column(name="PRICE")
    public BigDecimal getPrice() {
        return price;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CART_TRAVEL",
            joinColumns = {@JoinColumn(name = "TRAVEL_ID",referencedColumnName = "TRAVEL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID",referencedColumnName = "CART_ID")}
    )
    public List<Cart> getCarts() {
        return carts;
    }

    @ManyToOne
    @JoinColumn(name="TYPE_ID")
    public Type getType() {
        return type;
    }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "RESERVATION_ID")
    public Reservation getReservation() {
        return reservation;
    }

    public void setTravelId(Long travelId) {
        this.travelId = travelId;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public void setTravelDescritpion(String travelDescritpion) {
        this.travelDescritpion = travelDescritpion;
    }

    public void setTravelStartDate(LocalDate travelSartDate) {
        this.travelStartDate = travelSartDate;
    }

    public void setTravelEndDate(LocalDate travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
