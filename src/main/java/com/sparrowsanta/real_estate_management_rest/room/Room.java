package com.sparrowsanta.real_estate_management_rest.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparrowsanta.real_estate_management_rest.client.Client;
import com.sparrowsanta.real_estate_management_rest.flat.Flat;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Room extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private double roomSquareMeters;
    private double expectedRentPrice;
    private RoomType roomType;
    @Lob
    private byte[] picUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Flat flat;

    private boolean occupiable;

    @OneToOne
    @JoinColumn(name = "client_id", unique = true)
    private Client client;


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

}

