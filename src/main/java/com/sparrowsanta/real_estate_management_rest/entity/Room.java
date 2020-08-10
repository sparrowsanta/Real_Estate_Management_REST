package com.sparrowsanta.real_estate_management_rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Arrays;

@Data
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Flat flat;

    private RoomType roomType;
    private String description;
    private int occupable;
    private double roomSquareMeters;
    private double expectedRentPrice;


    @AllArgsConstructor
    @Getter
    public enum RoomType {
        ROOM(1),
        BATHROOM(2),
        TOILET(3),
        KITCHEN(4),
        HALL(5),
        BALCONY(6),
        GARDEN(7),
        GARAGE(8),
        BASEMENT(9);

        int value;

        public static RoomType valueOf(int value) {
            return Arrays.stream(values())
                    .filter(roomType -> roomType.value == value)
                    .findFirst()
                    .orElse(null);
        }
    }

    public Room() {

    }

    //Testowy
    public Room(long id, String description, double roomSquareMeters, double expectedRentPrice, RoomType roomType) {
        this.id = id;
        this.roomType = roomType;
        this.description = description;
        this.roomSquareMeters = roomSquareMeters;
        this.expectedRentPrice = expectedRentPrice;
    }

    public Room(long id, String description, double roomSquareMeters, double expectedRentPrice, RoomType roomType, int occupable) {
        this.id = id;
        this.roomType = roomType;
        this.description = description;
        this.roomSquareMeters = roomSquareMeters;
        this.expectedRentPrice = expectedRentPrice;
        this.occupable = occupable;
    }

}

