package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("property-insured")
public class Property extends BaseInsured {

    private int year;
    private int floorAmount;
    private BigDecimal price;
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<PropertyPolicy> policies = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;


}