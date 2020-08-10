package com.sparrowsanta.real_estate_management_rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "flat")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;
    @NotEmpty
    private String flatNumber;
    @NotEmpty
    private String zipCode;

    private int roomsNumber;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<>();

    private int floorNumber;
    private String flatDescription;
    private double flatSquareMeters;
    private int yearOfConstruction;
    private double flatPrice;
    private double expectedIncome;

    @OneToMany
    @JoinColumn(name = "flatId")
    private List<Meters> meters = new ArrayList<>();

//    private byte picUrl;


    public Flat() {
    }
}
