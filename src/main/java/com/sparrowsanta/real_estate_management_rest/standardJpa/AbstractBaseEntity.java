package com.sparrowsanta.real_estate_management_rest.standardJpa;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public class AbstractBaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
