package com.sparrowsanta.real_estate_management_rest.rent;

import com.sparrowsanta.real_estate_management_rest.furniture.Furniture;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends AbstractBaseRepository<Furniture, Long> {
}
