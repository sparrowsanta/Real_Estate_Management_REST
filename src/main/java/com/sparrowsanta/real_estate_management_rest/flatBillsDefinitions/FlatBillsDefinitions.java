package com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class FlatBillsDefinitions extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long flatId;
    private String billDescription;
    private double billAmount;
    private String currency;
    private int billFrequencyInMonths;
    private int paymentTillDayOfMonth;
    private String incomeOutcome;
}
