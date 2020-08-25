package com.sparrowsanta.real_estate_management_rest.flatBills;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class FlatBills extends AbstractBaseEntity {
    private long id;
    private long billDefinitionId;
    private double amount;
    private boolean paid;
    private LocalDate paymentDate;
}
