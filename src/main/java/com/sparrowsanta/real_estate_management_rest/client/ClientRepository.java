package com.sparrowsanta.real_estate_management_rest.client;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends AbstractBaseService<Client, Long> {
}
