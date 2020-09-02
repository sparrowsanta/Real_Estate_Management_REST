package com.sparrowsanta.real_estate_management_rest.rent;

import com.sparrowsanta.real_estate_management_rest.furniture.Furniture;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends AbstractBaseRepository<Rent, Long> {

    @Query(value = "SELECT r FROM Rent r WHERE r.room.id = ?1")
    List<Rent> getRentByRoomId(long roomId);
}
