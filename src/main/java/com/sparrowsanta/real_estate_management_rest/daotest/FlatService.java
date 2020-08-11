package com.sparrowsanta.real_estate_management_rest.daotest;

import com.sparrowsanta.real_estate_management_rest.entity.Flat;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FlatService {

    IGenericDAO<Flat> dao;

    @Autowired
    public void setDao(IGenericDAO<Flat> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Flat.class);
    }



    // ...

}
