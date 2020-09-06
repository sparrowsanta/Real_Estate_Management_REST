package com.sparrowsanta.real_estate_management_rest.rent;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RentRepository extends AbstractBaseRepository<Rent, Long> {

    @Query(value = "SELECT r FROM Rent r WHERE r.room.id = ?1")
    List<Rent> getRentByRoomId(long roomId);

    @Query(value = "SELECT r FROM Rent r WHERE r.room.id = ?1 AND FUNCTION('DATEDIFF', FUNCTION('NOW'), r.rentDateFrom) >= 0 AND FUNCTION('DATEDIFF', r.rentDateTo, FUNCTION('NOW'))  >= 0 ORDER BY FUNCTION('DATEDIFF', r.rentDateTo, FUNCTION('NOW'))")
    List<Rent> getMostRecentRent(long roomId, Pageable pageable);
}
