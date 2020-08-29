package com.sparrowsanta.real_estate_management_rest.flatBills;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class FlatBills extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long flatId;
    private long billDefinitionId;
    private double amount;
    private boolean paid;
    private boolean income;
    private String description;
    private String currency;
    private LocalDate paymentDate;
}
