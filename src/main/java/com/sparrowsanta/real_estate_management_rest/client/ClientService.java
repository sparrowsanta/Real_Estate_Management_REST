package com.sparrowsanta.real_estate_management_rest.client;

import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements AbstractBaseService<Client, Long> {


    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

//    public List<ClientForRoomView> showClientForRentView() {
//        List<ClientForRoomView> clientForRoomView = clientRepository.getClientById2(1L);
//        return clientForRoomView;
//    }

    @Override
    public Client save(Client entity) {

        return clientRepository.save(entity);
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Optional<Client> findById(Long entityId) {
        Optional<Client> clientOptional = clientRepository.findById(entityId);
        return clientOptional;
    }

    @Override
    public Client update(Client entity) {
        Client client = clientRepository.save(entity);
        return client;
    }

    @Override
    public Client updateById(Client entity, Long entityId) {
        Optional<Client> clientOptional = clientRepository.findById(entityId);
        if (clientOptional.isPresent()) {
            return clientRepository.save(entity);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Client entity) {
        clientRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        clientRepository.deleteById(entityId);
    }

    @Override
    public Client getOne(Long entityId) {
        Client client = clientRepository.getOne(entityId);
        return client;
    }
}
