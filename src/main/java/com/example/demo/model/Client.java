package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"policy", "vehicle"}, callSuper = false)
public class Client extends BaseEntity {

    private String fullName;
    private Date dateOfBirth;
    private String emailAddress;
    @Cascade({CascadeType.ALL})
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Vehicle> vehicle = new ArrayList<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<BasePolicy> policy = new ArrayList<>();
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Property> properties = new ArrayList<>();
}
