package com.sparrowsanta.real_estate_management_rest.flat;

import com.google.gson.Gson;
import com.sparrowsanta.real_estate_management_rest.client.Client;
import com.sparrowsanta.real_estate_management_rest.client.ClientForRoomView;
import com.sparrowsanta.real_estate_management_rest.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("flats")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private ClientService clientService;


    @GetMapping("/getAllFlats")
    public List<Flat> getFlats() {
        return flatService.findAll();
    }

    @PostMapping(value = "/addFlat", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long addFlat(@RequestBody Flat flatData) {
        System.out.println(flatData);
        Flat flat = flatService.save(flatData);
        return flat.getId();
    }


//    @GetMapping("/projection")
//    @ResponseBody
//    public List<ClientForRoomView> test() {
//
//        List<ClientForRoomView> clientForRoomViews = clientService.showClientForRentView();
//        return clientForRoomViews;
//    }
}
