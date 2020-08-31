package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatService implements AbstractBaseService<Flat, Long> {

    private final FlatRepository flatRepository;
//    private AbstractBaseRepositoryImpl<Flat, Long> abstractBaseRepositoryImpl;

    @Autowired
    public FlatService(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
//        this.abstractBaseRepositoryImpl = abstractBaseRepositoryImpl;
    }


    @Override
    public Flat save(Flat entity) {
        return flatRepository.save(entity);
    }

    @Override
    public List<Flat> findAll() {
        return flatRepository.findAll();
    }

    @Override
    public Optional<Flat> findById(Long entityId) {
        return flatRepository.findById(entityId);

    }

    @Override
    public Flat update(Flat entity) {
        return flatRepository.save(entity);
    }

    @Override
    public Flat updateById(Flat entity, Long entityId) {
        Optional<Flat> flatOptional = flatRepository.findById(entityId);
        if (flatOptional.isPresent()) {
            return flatRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Flat entity) {
        flatRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        flatRepository.deleteById(entityId);
    }

    @Override
    public Flat getOne(Long entityId) {
        return flatRepository.getOne(entityId);
    }


}