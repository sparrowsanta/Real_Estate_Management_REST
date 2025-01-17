package com.sparrowsanta.real_estate_management_rest.metersHistory;

import com.sparrowsanta.real_estate_management_rest.meters.Meters;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class MetersHistory extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long meterId;
    private LocalDate meterReadingDate;
    private double readingValue;

    public MetersHistory() {
    }

}
