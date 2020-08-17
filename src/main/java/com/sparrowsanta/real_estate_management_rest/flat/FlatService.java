package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;


public interface FlatService extends AbstractBaseService<Flat, Long> {

    Flat myOwnSave(Flat flat);

}