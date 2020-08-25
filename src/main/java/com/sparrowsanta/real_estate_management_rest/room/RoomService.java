package com.sparrowsanta.real_estate_management_rest.room;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoomService implements AbstractBaseService<Room, Long> {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public Room save(Room entity) {
        roomRepository.save(entity);
        return entity;
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms;

    }

    @Override
    public Optional<Room> findById(Long entityId) {
        Optional<Room> room = roomRepository.findById(entityId);
        return room;
    }


    @Override
    public Room update(Room entity) {
        roomRepository.save(entity);
        return entity;
    }

    @Override
    public Room updateById(Room entity, Long entityId) {

        Optional<Room> optional = roomRepository.findById(entityId);
        if (optional.isPresent()) {
            return roomRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Room entity) {
        roomRepository.delete(entity);
    }


    @Override
    public void deleteById(Long entityId) {
        roomRepository.deleteById(entityId);

    }

    @Override
    public Room getOne(Long entityId) {
        Room room = roomRepository.getOne(entityId);
        return room;
    }

}