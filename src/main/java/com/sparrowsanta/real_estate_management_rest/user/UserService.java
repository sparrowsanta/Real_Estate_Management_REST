package com.sparrowsanta.real_estate_management_rest.user;


import com.sparrowsanta.real_estate_management_rest.flat.FlatRepository;
import com.sparrowsanta.real_estate_management_rest.meters.Meters;
import com.sparrowsanta.real_estate_management_rest.meters.MetersRepository;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements AbstractBaseService<Meters, Long> {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Meters save(Meters entity) {
        return null;
    }

    @Override
    public List<Meters> findAll() {
        return null;
    }

    @Override
    public Optional<Meters> findById(Long entityId) {
        return Optional.empty();
    }

    @Override
    public Meters update(Meters entity) {
        return null;
    }

    @Override
    public Meters updateById(Meters entity, Long entityId) {
        return null;
    }

    @Override
    public void delete(Meters entity) {

    }

    @Override
    public void deleteById(Long entityId) {

    }

    @Override
    public Meters getOne(Long entityId) {
        return null;
    }
}
