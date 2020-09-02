package com.sparrowsanta.real_estate_management_rest.flatBills;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlatBillsRepository extends AbstractBaseRepository<FlatBills, Long> {

    List<FlatBills> findAllByFlatIdOrderByPaymentDateDesc(Long flatId);

    List<FlatBills> findAllByPaidOrderByPaymentDateDesc(boolean paid);

    FlatBills findFirstByBillDefinitionIdOrderByPaymentDateDesc(Long billDefinitionId);

}
