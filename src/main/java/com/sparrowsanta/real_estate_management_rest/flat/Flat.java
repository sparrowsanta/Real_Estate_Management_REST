package com.sparrowsanta.real_estate_management_rest.flat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparrowsanta.real_estate_management_rest.meters.Meters;
import com.sparrowsanta.real_estate_management_rest.room.Room;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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

    @OneToMany(mappedBy = "flat", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
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

    @Lob
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private byte[] picUrl;


    public Flat() {
    }
}
