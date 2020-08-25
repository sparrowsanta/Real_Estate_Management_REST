package com.sparrowsanta.real_estate_management_rest.flatBillsDefinitions;


import com.sparrowsanta.real_estate_management_rest.flatBills.FlatBills;
import com.sparrowsanta.real_estate_management_rest.rent.Rent;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatBillsDefinitionsService implements AbstractBaseService<FlatBillsDefinitions, Long> {

    private FlatBillsDefinitionsRepository flatBillsDefinitionsRepository;

    @Autowired
    public FlatBillsDefinitionsService(FlatBillsDefinitionsRepository flatBillsDefinitionsRepository) {
        this.flatBillsDefinitionsRepository = flatBillsDefinitionsRepository;
    }

    @Override
    public FlatBillsDefinitions save(FlatBillsDefinitions entity) {
        FlatBillsDefinitions flatBillsDefinitions = flatBillsDefinitionsRepository.save(entity);
        return flatBillsDefinitions;
    }

    @Override
    public List<FlatBillsDefinitions> findAll() {
        List<FlatBillsDefinitions> flatBillsDefinitionsRepositoryAll = flatBillsDefinitionsRepository.findAll();
        return flatBillsDefinitionsRepositoryAll;
    }

    @Override
    public Optional<FlatBillsDefinitions> findById(Long entityId) {
        Optional<FlatBillsDefinitions> optionalFlatBillsDefinitions = flatBillsDefinitionsRepository.findById(entityId);
        return optionalFlatBillsDefinitions;
    }


    @Override
    public FlatBillsDefinitions update(FlatBillsDefinitions entity) {
        FlatBillsDefinitions flatBillsDefinitions = flatBillsDefinitionsRepository.save(entity);
        return flatBillsDefinitions;
    }

    @Override
    public FlatBillsDefinitions updateById(FlatBillsDefinitions entity, Long entityId) {
        Optional<FlatBillsDefinitions> flatBillsDefinitionsOptional = flatBillsDefinitionsRepository.findById(entityId);
        if (flatBillsDefinitionsOptional.isPresent()) {
            return flatBillsDefinitionsRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(FlatBillsDefinitions entity) {
        flatBillsDefinitionsRepository.delete(entity);
    }


    @Override
    public void deleteById(Long entityId) {
        flatBillsDefinitionsRepository.deleteById(entityId);
    }

    @Override
    public FlatBillsDefinitions getOne(Long entityId) {
        FlatBillsDefinitions flatBillsDefinitions = flatBillsDefinitionsRepository.getOne(entityId);
        return flatBillsDefinitions;
    }

}
