package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlatService {

    private FlatRepository flatRepository;
//    private AbstractBaseRepositoryImpl<Flat, Long> abstractBaseRepositoryImpl;

    @Autowired
    public FlatService(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
//        this.abstractBaseRepositoryImpl = abstractBaseRepositoryImpl;
    }

    public AbstractBaseEntity save(Flat entity) {
        AbstractBaseEntity flat = flatRepository.save(entity);
        return flat;
    }

    public List<Flat> findAll() {
        List flats = flatRepository.findAll();
        return flats;
    }

    public Optional<Flat> findById(Long entityId) {
        Optional<Flat> optionalFlat = flatRepository.findById(entityId);
        return optionalFlat.empty();
    }

/*    public Flat update(Flat entity) {
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
    }*/

}