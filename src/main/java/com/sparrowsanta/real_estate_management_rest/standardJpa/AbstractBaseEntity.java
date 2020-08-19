package com.sparrowsanta.real_estate_management_rest.standardJpa;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass //Dopytać o to
public class AbstractBaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
