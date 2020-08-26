package com.sparrowsanta.real_estate_management_rest.meters;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Arrays;

@Data
@AllArgsConstructor
@Entity
public class Meters extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private MeterType meterType;
    private String description;

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
/*    public Meters(MeterType meterType, String description) {

        this.meterType = meterType;
        this.description = description;
    }*/
    public Meters() {
    };

}
