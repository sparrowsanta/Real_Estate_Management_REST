package com.sparrowsanta.real_estate_management_rest.metersHistory;

import com.sparrowsanta.real_estate_management_rest.meters.Meters;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
public class MetersHistory extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Meters meter;
    private LocalDate meterReadingDate;
    private double readingValue;

    public MetersHistory() {

    }
}
