package com.sparrowsanta.real_estate_management_rest.room;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends AbstractBaseRepository<Room, Long> {
}
