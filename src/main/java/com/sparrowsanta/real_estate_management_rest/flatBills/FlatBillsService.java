package com.sparrowsanta.real_estate_management_rest.flatBills;


import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlatBillsService implements AbstractBaseService<FlatBills, Long> {

    private FlatBillsRepository flatBillsRepository;

    private String[] months;
    private String[] billsDefPerMonth;
    private String[] billsPaidPerMonth;
    private final PageRequest pageRequest = PageRequest.of(0, 5);
    List<String[]> getAllBillsDefinitionPerMonth = new ArrayList<>();

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

    public List<FlatBills> getBillsByFlatIdAndFilter(Long flatId, String paidFilter, String typeFilter, String dateFromFilter, String dateToFilter) {
        List<FlatBills> paymentsList = flatBillsRepository.findAllByFlatIdOrderByPaymentDateDesc(flatId);

        paymentsList = paymentsList.stream()
                .filter(paidFilter.equals("paid") ? FlatBills::isPaid : x -> true)
                .filter(paidFilter.equals("notPaid") ? x -> !x.isPaid() : x -> true)
                .filter(!typeFilter.equals("all") ? x -> x.getIncomeOutcome().equals(typeFilter) : x -> true)
                .filter(!dateFromFilter.equals("-") ?
                        x -> (x.getPaymentDate().isAfter(LocalDate.parse(dateFromFilter)) || (x.getPaymentDate().isEqual(LocalDate.parse(dateFromFilter))))
                        : x -> true)
                .filter(!dateToFilter.equals("-") ?
                        x -> (x.getPaymentDate().isBefore(LocalDate.parse(dateToFilter)) || (x.getPaymentDate().isEqual(LocalDate.parse(dateToFilter))))
                        : x -> true)
                .collect(Collectors.toList());

        return paymentsList;
    }

    public List<String[]> getAllBillsDefinitionPerMonth(long flatId) {
        getAllBillsDefinitionPerMonth.clear();
        months = flatBillsRepository.getMonths();
        billsDefPerMonth = flatBillsRepository.getSumBillsDefinitionPerMonth(flatId);
        billsPaidPerMonth = flatBillsRepository.getSumBillsPerMonth(flatId);


        Collections.reverse(Arrays.asList(months));
        Collections.reverse(Arrays.asList(billsDefPerMonth));
        Collections.reverse(Arrays.asList(billsPaidPerMonth));

        getAllBillsDefinitionPerMonth.add(months);
        getAllBillsDefinitionPerMonth.add(billsDefPerMonth);
        getAllBillsDefinitionPerMonth.add(billsPaidPerMonth);
        return getAllBillsDefinitionPerMonth;
    }

    public FlatBills getLastPaymentByBillDefinitionId(Long billDefinitionId) {
        return flatBillsRepository.findFirstByBillDefinitionIdOrderByPaymentDateDesc(billDefinitionId);
    }

}
