package com.sparrowsanta.real_estate_management_rest.client;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends AbstractBaseRepository<Client, Long> {

//    List<ClientForRoomView> getClientById(long id);



}
