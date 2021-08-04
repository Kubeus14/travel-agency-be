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
@Entity(name = "TYPE")
public class Type {

    private Long typeId;
    private String typeName;
    private List<Travel> travels = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="TYPE_ID")
    public Long getTypeId() {
        return typeId;
    }
    @Column(name="TYPE_NAME")
    public String getTypeName() {
        return typeName;
    }
    @OneToMany(
            targetEntity = Travel.class,
            mappedBy = "type",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Travel> getTravels() {
        return travels;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setTravels(List<Travel> travels) {
        this.travels = travels;
    }


}
