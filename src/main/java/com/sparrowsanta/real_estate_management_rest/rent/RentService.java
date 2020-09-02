package com.sparrowsanta.real_estate_management_rest.rent;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class RentService implements AbstractBaseService<Rent, Long> {

    private RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }


    @Override
    public Rent save(Rent entity) {
        Rent rent = rentRepository.save(entity);
        return rent;
    }

    @Override
    public List<Rent> findAll() {
        List<Rent> rents = rentRepository.findAll();
        return rents;
    }

    @Override
    public Optional<Rent> findById(Long entityId) {
        Optional<Rent> rentOptional = rentRepository.findById(entityId);
        return rentOptional;
    }

    @Override
    public Rent update(Rent entity) {
        Rent rent = rentRepository.save(entity);
        return rent;
    }

    @Override
    public Rent updateById(Rent entity, Long entityId) {
        Optional<Rent> rentOptional = rentRepository.findById(entityId);
        if (rentOptional.isPresent()) {
            return rentRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Rent entity) {
        rentRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        rentRepository.deleteById(entityId);
    }

    @Override
    public Rent getOne(Long entityId) {
        Rent rent = rentRepository.getOne(entityId);
        return rent;
    }

    public List<Rent> getRentHistoryByRoomId(long roomId){
        List<Rent> rentByRoomId = rentRepository.getRentByRoomId(roomId);
        return rentByRoomId;
    }
}