package com.sparrowsanta.real_estate_management_rest.flatBills;


import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatBillsService implements AbstractBaseService<FlatBills, Long> {

    private FlatBillsRepository flatBillsRepository;

    @Autowired
    public FlatBillsService(FlatBillsRepository flatBillsRepository) {
        this.flatBillsRepository = flatBillsRepository;
    }

    @Override
    public FlatBills save(FlatBills entity) {
        FlatBills flatBills = flatBillsRepository.save(entity);
        return flatBills;
    }

    @Override
    public List<FlatBills> findAll() {
        List<FlatBills> flatBillsRepositoryAll = flatBillsRepository.findAll();
        return flatBillsRepositoryAll;
    }

    @Override
    public Optional<FlatBills> findById(Long entityId) {
        Optional<FlatBills> optionalFlatBills = flatBillsRepository.findById(entityId);
        return optionalFlatBills;
    }

    @Override
    public FlatBills update(FlatBills entity) {
        FlatBills flatBills = flatBillsRepository.save(entity);
        return flatBills;
    }

    @Override
    public FlatBills updateById(FlatBills entity, Long entityId) {
        Optional<FlatBills> optionalFlatBills = flatBillsRepository.findById(entityId);
        if (optionalFlatBills.isPresent()) {
            return flatBillsRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(FlatBills entity) {
        flatBillsRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        flatBillsRepository.deleteById(entityId);
    }

    @Override
    public FlatBills getOne(Long entityId) {
        FlatBills flatBills = flatBillsRepository.getOne(entityId);
        return flatBills;
    }

    public List<FlatBills> getBillsByFlatIdAndFilter(Long flatId, String filter) {
        return filter.equals("all") ? flatBillsRepository.findAllByFlatId(flatId) :
                flatBillsRepository.findAllByPaid(filter.equals("paid"));
    }

    public FlatBills getLastPaymentByBillDefinitionId(Long billDefinitionId) {
        return flatBillsRepository.findFirstByBillDefinitionIdOrderByPaymentDateDesc(billDefinitionId);
    }

}
