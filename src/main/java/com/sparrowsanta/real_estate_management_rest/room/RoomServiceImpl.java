package com.sparrowsanta.real_estate_management_rest.room;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImpl extends AbstractBaseRepositoryImpl<Room, Long> implements RoomService {
    //Is that neccessery?
    @Autowired
    private RoomRepository roomRepository;


    public RoomServiceImpl(RoomRepository roomRepository) {
        super(roomRepository);
    }

}
