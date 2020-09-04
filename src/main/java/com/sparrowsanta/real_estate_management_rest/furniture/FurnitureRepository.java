package com.sparrowsanta.real_estate_management_rest.furniture;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FurnitureRepository extends AbstractBaseRepository<Furniture, Long> {

    List<Furniture> findAllByRoomId(long roomId);

    void deleteAllByRoomId(long roomId);
}
