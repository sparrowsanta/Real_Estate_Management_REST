package com.sparrowsanta.real_estate_management_rest.client;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends AbstractBaseRepository<Client, Long> {

    List<ClientForRoomView> getClientById(long id);
}
