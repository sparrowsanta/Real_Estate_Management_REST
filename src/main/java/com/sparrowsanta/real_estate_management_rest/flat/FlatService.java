package com.sparrowsanta.real_estate_management_rest.flat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlatService {

    private FlatRepository flatRepository;

    @Autowired
    public FlatService(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public Flat saveFlat(Flat flat) {
        flatRepository.save(flat);
        return flat;
    }

    public List<Flat> showFlats() {
        List<Flat> flats = flatRepository.findAll();
        return flats;
    }
}