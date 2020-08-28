package com.sparrowsanta.real_estate_management_rest.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sparrowsanta.real_estate_management_rest.utils.HibernateProxyTypeAdapter;
import org.javers.hibernate.HibernateUnproxyObjectAccessHook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/addClient", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String saveClient(@RequestBody Client client) {
        clientService.save(client);
        return new Gson().toJson("OK");
    }

    @PutMapping(value = "/addClient/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String editClient(@PathVariable(name = "id") long id, @RequestBody Client data) {
        clientService.updateById(data, id);
        return new Gson().toJson("OK");
    }

    @GetMapping(value = "/showClientsAll", produces = "text/plain;charset=UTF-8")
    @ResponseBody
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


    @GetMapping(value = "/getClient/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getClient(@PathVariable(name = "id") long id) {
        Client client = clientService.getOne(id);
        GsonBuilder b = new GsonBuilder();

        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = b.create();
        return  gson.toJson(client);
    }


}
