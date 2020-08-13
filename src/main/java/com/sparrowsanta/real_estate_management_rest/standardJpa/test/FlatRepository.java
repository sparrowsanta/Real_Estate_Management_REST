package com.sparrowsanta.real_estate_management_rest.standardJpa.test;

import com.sparrowsanta.real_estate_management_rest.entity.Flat;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends AbstractBaseRepository<Flat, Long> {

}