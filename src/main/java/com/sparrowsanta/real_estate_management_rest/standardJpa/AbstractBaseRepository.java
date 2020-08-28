package com.sparrowsanta.real_estate_management_rest.standardJpa;

import org.javers.spring.data.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.PersistenceContext;
import java.io.Serializable;

@NoRepositoryBean
@JaversSpringDataAuditable
//do sprawdzenia dlaczego norepositoy
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {


}

