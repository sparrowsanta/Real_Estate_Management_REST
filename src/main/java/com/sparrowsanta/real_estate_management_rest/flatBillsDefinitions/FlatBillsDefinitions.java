package com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class FlatBillsDefinitions extends AbstractBaseEntity {
    private long id;
    private long flatId;
    private String billDescription;
    private double billAmount;
    private String currency;
    private int billFrequencyInMonths;
    private LocalDate lastPaymentDone;
    private int paymentTillDayOfMonth;
}
