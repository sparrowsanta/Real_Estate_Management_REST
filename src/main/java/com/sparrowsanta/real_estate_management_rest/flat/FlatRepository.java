package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FlatRepository extends AbstractBaseRepository<Flat, Long> {

    @Query("SELECT b FROM Flat b WHERE b.flatNumber =?1")
    List<Flat> myOwnFindBy(String flatNumber);

    Optional<Flat> findById(Long id);

    @Query(value = "SELECT f.picUrl FROM Flat f WHERE f.id = ?1")
    byte[] picFlatUrlById(long id);
}