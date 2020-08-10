package com.sparrowsanta.real_estate_management_rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Furniture {
    private long id;
    private String description;
    private long roomId;
    private LocalDate dateOfPurchase;
    private long value;

}
