package com.sparrowsanta.real_estate_management_rest.furniture;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FurnitureRepository extends AbstractBaseRepository<Furniture, Long> {
}
