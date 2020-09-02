package com.sparrowsanta.real_estate_management_rest.user;


import com.sparrowsanta.real_estate_management_rest.flat.FlatRepository;
import com.sparrowsanta.real_estate_management_rest.meters.Meters;
import com.sparrowsanta.real_estate_management_rest.meters.MetersRepository;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements AbstractBaseService<User, Long> , UserDetailsService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long entityId) {
        return Optional.empty();
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User updateById(User entity, Long entityId) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteById(Long entityId) {

    }

    @Override
    public User getOne(Long entityId) {
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if ("realestate".equals(s)) {
            return new User("realestate", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6");
        } else {
            throw new UsernameNotFoundException("User not found with username: " + s);
        }
    }
}
