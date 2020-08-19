package com.sparrowsanta.real_estate_management_rest.furniture;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepositoryImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class FurnitureServiceImpl extends AbstractBaseRepositoryImpl<Furniture, Long> implements FurnitureService {

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository) {
        super(furnitureRepository);
    }
}
