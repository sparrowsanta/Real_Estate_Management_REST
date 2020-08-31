package com.sparrowsanta.real_estate_management_rest.meters;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetersRepository extends AbstractBaseRepository<Meters, Long> {

    List<Meters> findAllByFlatId (Long flatId);
}
