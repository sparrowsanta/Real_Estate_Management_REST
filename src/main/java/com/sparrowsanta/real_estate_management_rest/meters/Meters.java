package com.sparrowsanta.real_estate_management_rest.meters;

import com.sparrowsanta.real_estate_management_rest.metersHistory.MetersHistory;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Meters extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long flatId;
    @OneToMany(mappedBy = "meter",cascade = CascadeType.REMOVE)
    private List<MetersHistory> metersHistory = new ArrayList<>();
    private MeterType meterType;
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;

    @AllArgsConstructor
    @Getter
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
