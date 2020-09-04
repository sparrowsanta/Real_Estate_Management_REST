package com.sparrowsanta.real_estate_management_rest.room;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoomRepository extends AbstractBaseRepository<Room, Long> {

    List<Room> findAllByFlatId(long flatId);

    @Query(value = "SELECT r.picUrl FROM Room r WHERE r.id = ?1")
    byte[] picUrlById(long id);

    @Query(value = "UPDATE room r SET description = ?1, room_square_meters = ?2, expected_rent_price = ?3, room_type = ?4 WHERE r.id = ?5", nativeQuery = true)
    @Modifying
    void updateRoomDetails(String description, double roomSquareMeters, double expectedRentPrice, int roomType, long id);

    @Query(value = "SELECT DISTINCT r.flat.id FROM Room r WHERE r.id = ?1")
    long flatByMyRoomId(long roomId);

}
