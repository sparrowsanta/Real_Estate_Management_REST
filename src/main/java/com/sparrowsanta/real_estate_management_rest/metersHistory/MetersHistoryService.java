package com.sparrowsanta.real_estate_management_rest.metersHistory;


import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetersHistoryService implements AbstractBaseService<MetersHistory, Long> {

    private MetersHistoryRepository metersHistoryRepository;

    @Autowired
    public MetersHistoryService(MetersHistoryRepository metersHistoryRepository) {
        this.metersHistoryRepository = metersHistoryRepository;
    }

    @Override
    public MetersHistory save(MetersHistory entity) {
        MetersHistory mh = metersHistoryRepository.save(entity);
        return mh;
    }

    @Override
    public List<MetersHistory> findAll() {
        List<MetersHistory> mhs = metersHistoryRepository.findAll();
        return mhs;
    }

    @Override
    public Optional<MetersHistory> findById(Long entityId) {
        Optional<MetersHistory> mho = metersHistoryRepository.findById(entityId);
        return mho;
    }

    @Override
    public MetersHistory update(MetersHistory entity) {
        MetersHistory mh = metersHistoryRepository.save(entity);
        return mh;
    }

    @Override
    public MetersHistory updateById(MetersHistory entity, Long entityId) {
        Optional<MetersHistory> mho = metersHistoryRepository.findById(entityId);
        if (mho.isPresent()) {
            return metersHistoryRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(MetersHistory entity) {
        metersHistoryRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        metersHistoryRepository.deleteById(entityId);
    }

    @Override
    public MetersHistory getOne(Long entityId) {
        return null;
    }

    public List<MetersHistory> findReadingsHistoryByMeterId (Long meterId){
        return metersHistoryRepository.findAllByMeterIdOrderByMeterReadingDateDesc(meterId);
    }
}
