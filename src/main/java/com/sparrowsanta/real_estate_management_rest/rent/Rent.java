package com.sparrowsanta.real_estate_management_rest.rent;

import com.sparrowsanta.real_estate_management_rest.client.Client;
import com.sparrowsanta.real_estate_management_rest.room.Room;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@Entity
public class Rent extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate rentDateFrom;
    private LocalDate rentDateTo;
    private long rentAmount;
    @OneToOne
    private Client client;
    @OneToOne
    private Room room;

    public Rent() {
    }

}
