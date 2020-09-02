package com.sparrowsanta.real_estate_management_rest.user;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractBaseRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
