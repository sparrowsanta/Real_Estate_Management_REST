package com.sparrowsanta.real_estate_management_rest.metersHistory;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
public class MetersHistory extends AbstractBaseEntity {
    private long id;
    private long meterId;
    private LocalDate meterReadingDate;
    private double readingValue;

    public MetersHistory() {

    }
}
