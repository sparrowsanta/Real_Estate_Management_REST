package com.sparrowsanta.real_estate_management_rest.meters;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Meters extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long flatId;
    private MeterType meterType;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Getter
    @AllArgsConstructor
    public enum MeterType {
        ELECTRICITY(1),
        WATER_COLD(2),
        WATER_HOT(3),
        GAS(4),
        HEATING(5);

        int value;

        public static MeterType valueOf(int value) {
            return Arrays.stream(values())
                    .filter(meterType -> meterType.value == value)
                    .findFirst()
                    .orElse(null);
        }
    }


    public Meters(MeterType meterType, String description) {
        this.meterType = meterType;
        this.description = description;
    }

    @PrePersist
    public void setCreated() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updated = LocalDateTime.now();
    }

    public Meters() {
    }

}
