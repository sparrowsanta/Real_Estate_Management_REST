package com.sparrowsanta.real_estate_management_rest.meters;


import com.sparrowsanta.real_estate_management_rest.metersHistory.MetersHistory;
import com.sparrowsanta.real_estate_management_rest.metersHistory.MetersHistoryRepository;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetersService implements AbstractBaseService<Meters, Long> {


    private MetersRepository metersRepository;

    @Autowired
    public MetersService(MetersRepository metersRepository) {
        this.metersRepository = metersRepository;
    }

    @Override
    public Meters save(Meters entity) {
        Meters meters = metersRepository.save(entity);
        return meters;
    }

    @Override
    public List<Meters> findAll() {
        List<Meters> meters = metersRepository.findAll();
        return meters;
    }

    @Override
    public Optional<Meters> findById(Long entityId) {
        Optional<Meters> metersOptional = metersRepository.findById(entityId);
        return metersOptional;
    }

    @Override
    public Meters update(Meters entity) {
        Meters meters = metersRepository.save(entity);
        return meters;
    }

    @Override
    public Meters updateById(Meters entity, Long entityId) {
        Optional<Meters> metersOptional = metersRepository.findById(entityId);
        if (metersOptional.isPresent()) {
            return metersRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Meters entity) {
        metersRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        metersRepository.deleteById(entityId);
    }

    @Override
    public Meters getOne(Long entityId) {
        Meters meters = metersRepository.getOne(entityId);
        return meters;
    }
}
