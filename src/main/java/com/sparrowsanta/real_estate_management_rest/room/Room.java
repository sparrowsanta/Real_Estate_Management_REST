package com.sparrowsanta.real_estate_management_rest.room;

import com.sparrowsanta.real_estate_management_rest.client.Client;
import com.sparrowsanta.real_estate_management_rest.flat.Flat;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;

@Data
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private double roomSquareMeters;
    private double expectedRentPrice;
    private RoomType roomType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flatId")
    private Flat flat;

    private boolean occupable;

    @OneToOne
    @JoinColumn(name = "client_id", unique = true)
    private Client client;


    @AllArgsConstructor
    @Getter
    public enum RoomType {
        ROOM,
        BATHROOM,
        TOILET,
        KITCHEN,
        HALL,
        BALCONY,
        GARDEN,
        GARAGE,
        BASEMENT;


        public static HashSet<String> getStatuses() {
            HashSet<String> statuses = new HashSet<String>();

            for (RoomType s : RoomType.values()) {
                statuses.add(s.name());
            }
            return statuses;

        }
    }

    public Room() {

    }

/*    //Testowy
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
    }*/

}

