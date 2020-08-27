package com.sparrowsanta.real_estate_management_rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("clients")
public class ClientController {

    @PostMapping(value = "/addClient", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String saveClient(@RequestBody String client) {
        System.out.println(client);
        return "OK";
    }
}
