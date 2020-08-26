package com.sparrowsanta.real_estate_management_rest.meters;

import com.sparrowsanta.real_estate_management_rest.furniture.Furniture;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetersRepository extends AbstractBaseRepository<Meters, Long> {
}
