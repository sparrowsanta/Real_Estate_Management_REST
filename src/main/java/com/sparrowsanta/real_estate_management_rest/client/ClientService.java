package com.sparrowsanta.real_estate_management_rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {


    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    public List<ClientForRoomView> showClientForRentView(){
        List<ClientForRoomView> clientForRoomView = clientRepository.getClientById(1L);
        return clientForRoomView;
    }

}
