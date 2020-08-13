package com.sparrowsanta.real_estate_management_rest.standardJpa;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface AbstractBaseService<T extends AbstractBaseEntity, ID extends Serializable> {
    T save(T entity);

    List<T> findAll(); // you might want a generic Collection if u prefer

    Optional<T> findById(ID entityId);

    T update(T entity);

    T updateById(T entity, ID entityId);

    void delete(T entity);

    void deleteById(ID entityId);

    // other methods u might need to be generic

}
