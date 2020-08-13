package com.sparrowsanta.real_estate_management_rest.standardJpa.test;

import com.sparrowsanta.real_estate_management_rest.entity.Flat;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepositoryImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlatServiceImpl extends AbstractBaseRepositoryImpl<Flat, Long> implements FlatService {
    private FlatRepository flatRepository;

    public FlatServiceImpl(FlatRepository flatRepository) {
        super(flatRepository);
    }
    // other specialized methods from the MyDomainService interface

}
