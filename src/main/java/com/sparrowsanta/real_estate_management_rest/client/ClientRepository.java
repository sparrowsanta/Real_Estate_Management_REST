package com.sparrowsanta.real_estate_management_rest.client;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import org.javers.spring.JaversAuditable;
import org.springframework.stereotype.Repository;

@Repository
@JaversAuditable
public interface ClientRepository extends AbstractBaseRepository<Client, Long> {

//    List<ClientForRoomView> getClientById(long id);
}
