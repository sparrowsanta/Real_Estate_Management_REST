package com.sparrowsanta.real_estate_management_rest.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sparrowsanta.real_estate_management_rest.utils.HibernateProxyTypeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/addClient", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PostMapping(value = "/addClient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Client editClient(@PathVariable(name = "id") long id, @RequestBody Client data) {
        return clientService.updateById(data, id);
    }

    @GetMapping(value = "/showClientsAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> showAllClients() {
        List<Client> clients = clientService.findAll();
        return clients;
    }

    @DeleteMapping(value = "/deleteClient/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteClient(@PathVariable(name = "id") long id) {
        clientService.deleteById(id);
        return "OK";
    }


    @GetMapping(value = "/getClient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getClient(@PathVariable(name = "id") long id) {
        GsonBuilder b = new GsonBuilder();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = b.create();
        return gson.toJson(clientService.getOne(id));
    }


}
