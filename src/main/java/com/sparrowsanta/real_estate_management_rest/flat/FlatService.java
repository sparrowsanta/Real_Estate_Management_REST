package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatService {

    private FlatRepository flatRepository;
    private AbstractBaseRepositoryImpl<Flat, Long> abstractBaseRepositoryImpl;

    @Autowired
    public FlatService(FlatRepository flatRepository, AbstractBaseRepositoryImpl abstractBaseRepository) {
        this.flatRepository = flatRepository;
        this.abstractBaseRepositoryImpl = abstractBaseRepository;
    }

    public Flat save(Flat entity) {
        Flat flat = abstractBaseRepositoryImpl.update(entity);
        return flat;
    }

    public List<Flat> findAll() {
        List flats = abstractBaseRepositoryImpl.findAll();
        return flats;
    }

    public Optional<Flat> findById(Long entityId) {
        Optional<Flat> optionalFlat = abstractBaseRepositoryImpl.findById(entityId);
        return optionalFlat.empty();
    }

    public Flat update(Flat entity) {
        Flat flat = abstractBaseRepositoryImpl.update(entity);
        return flat;
    }

    public Flat updateById(Flat entity, Long entityId) {
        Flat flat = abstractBaseRepositoryImpl.updateById(entity, entityId);
        return flat;
    }


    public Flat getOne(Long entityId) {
        Flat flat = abstractBaseRepositoryImpl.getOne(entityId);
        return flat;
    }

    public void delete(Flat entity) {
        abstractBaseRepositoryImpl.delete(entity);
    }

}