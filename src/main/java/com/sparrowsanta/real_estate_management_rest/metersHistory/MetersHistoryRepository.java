package com.sparrowsanta.real_estate_management_rest.metersHistory;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetersHistoryRepository extends AbstractBaseRepository<MetersHistory, Long> {
    List<MetersHistory> findAllByMeterIdOOrderByMeterReadingDateDesc (Long meterId);
}
