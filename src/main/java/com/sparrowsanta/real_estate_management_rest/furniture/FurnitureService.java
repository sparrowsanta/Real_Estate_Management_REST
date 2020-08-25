package com.sparrowsanta.real_estate_management_rest.furniture;


import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;

import java.util.List;
import java.util.Optional;

public class FurnitureService implements AbstractBaseService<Furniture, Long> {
    @Override
    public Furniture save(Furniture entity) {
        return null;
    }

    @Override
    public List<Furniture> findAll() {
        return null;
    }

    @Override
    public Optional<Furniture> findById(Long entityId) {
        return Optional.empty();
    }

    @Override
    public Furniture update(Furniture entity) {
        return null;
    }

    @Override
    public Furniture updateById(Furniture entity, Long entityId) {
        return null;
    }

    @Override
    public void delete(Furniture entity) {

    }

    @Override
    public void deleteById(Long entityId) {

    }

    @Override
    public Furniture getOne(Long entityId) {
        return null;
    }
}
