package com.sparrowsanta.real_estate_management_rest.daotest;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {
    T findOne(final long id);
    List<T> findAll();
    T create(final T entity);
    T update(final T entity);
    void delete(final T entity);
    void deleteById(final long entityId);

    void setClazz(Class<T> flatClass);
}
