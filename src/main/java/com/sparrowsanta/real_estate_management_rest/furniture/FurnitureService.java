package com.sparrowsanta.real_estate_management_rest.furniture;


import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class FurnitureService implements AbstractBaseService<Furniture, Long> {


    private FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public Furniture save(Furniture entity) {
        Furniture furniture = furnitureRepository.save(entity);
        return furniture;
    }

    @Override
    public List<Furniture> findAll() {
        List<Furniture> furnitures = furnitureRepository.findAll();
        return furnitures;
    }

    @Override
    public Optional<Furniture> findById(Long entityId) {
        Optional<Furniture> furnitureOptional = furnitureRepository.findById(entityId);
        return furnitureOptional;
    }

    @Override
    public Furniture update(Furniture entity) {
        Furniture furniture = furnitureRepository.save(entity);
        return furniture;
    }

    @Override
    public Furniture updateById(Furniture entity, Long entityId) {
        Optional<Furniture> furnitureOptional = furnitureRepository.findById(entityId);
        if (furnitureOptional.isPresent()) {
            return furnitureRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Furniture entity) {
        furnitureRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        furnitureRepository.deleteById(entityId);
    }

    @Override
    public Furniture getOne(Long entityId) {
        Furniture furniture = furnitureRepository.getOne(entityId);
        return furniture;
    }

    public List<Furniture> findAllByRoomId(long roomId) {
        List<Furniture> allByRoomId = furnitureRepository.findAllByRoomId(roomId);
        return allByRoomId;
    }

    public void updateFurnitures(Furniture[] data, long roomId) {
        furnitureRepository.deleteAllByRoomId(roomId);
        for (int i = 0; i < data.length; i++) {
            furnitureRepository.save(data[i]);
        }
    }
}
