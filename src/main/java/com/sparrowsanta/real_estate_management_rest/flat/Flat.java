package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.entity.Meters;
import com.sparrowsanta.real_estate_management_rest.entity.Room;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "flat")
public class Flat extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @AttributeOverride()
    private long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    @NotEmpty
    @Column(name = "flat_number")
    private String flatNumber;
    @NotEmpty
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "rooms_number")
    private int roomsNumber;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<>();

    @Column(name = "floor_number")
    private int floorNumber;
    @Column(name = "flat_description")
    private String flatDescription;
    @Column(name = "flat_square_meters")
    private double flatSquareMeters;
    @Column(name = "year_of_construction")
    private int yearOfConstruction;
    @Column(name = "flat_price")
    private double flatPrice;

    @Column(name = "expected_income")
    private double expectedIncome;

    @OneToMany
    @JoinColumn(name = "flatId")
    private List<Meters> meters = new ArrayList<>();

//    private byte picUrl;


    public Flat() {
    }
}
