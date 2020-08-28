package com.sparrowsanta.real_estate_management_rest.furniture;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@Entity
@Table(name = "furniture")
public class Furniture  extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private long roomId;
    @Past
    private LocalDate dateOfPurchase;
    @Min(1)
    private long value;
    public Furniture(){}
}
