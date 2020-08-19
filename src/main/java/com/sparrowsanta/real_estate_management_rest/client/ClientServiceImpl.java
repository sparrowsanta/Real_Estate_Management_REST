package com.sparrowsanta.real_estate_management_rest.client;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepository;
import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepositoryImpl;

public class ClientServiceImpl extends AbstractBaseRepositoryImpl<Client, Long> implements ClientService {

    public ClientServiceImpl(AbstractBaseRepository abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}
