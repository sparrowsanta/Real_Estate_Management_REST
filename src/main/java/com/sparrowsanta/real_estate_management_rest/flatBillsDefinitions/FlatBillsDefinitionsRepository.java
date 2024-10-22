package com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions;

import com.sparrowsanta.real_estate_management_rest.flatBills.FlatBills;
import com.sparrowsanta.real_estate_management_rest.furniture.Furniture;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatBillsDefinitionsRepository extends AbstractBaseRepository<FlatBillsDefinitions, Long> {
    List<FlatBillsDefinitions> findAllByFlatId (Long flatId);
}
