package com.sparrowsanta.real_estate_management_rest.rent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparrowsanta.real_estate_management_rest.client.Client;
import com.sparrowsanta.real_estate_management_rest.client.ClientService;
import com.sparrowsanta.real_estate_management_rest.room.Room;
import com.sparrowsanta.real_estate_management_rest.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rents")
public class RentController {
    private RentService rentService;
    private ClientService clientService;
    private RoomService roomService;
    private ObjectMapper mapper;


    @Autowired
    public RentController(ClientService clientService, RentService rentService, RoomService roomService, ObjectMapper objectMapper) {
        this.rentService = rentService;
        this.clientService = clientService;
        this.roomService = roomService;
        this.mapper = objectMapper;
    }

    @GetMapping(value = "/roomRentHistory/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rent> getRentHistoryByRoomId(@PathVariable(name = "roomId") long roomId) {
        return rentService.getRentHistoryByRoomId(roomId);
    }

    @PostMapping(value = "/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rent saveRentForRoom(@PathVariable(name = "roomId") long roomId, @RequestBody String rentDetails) {
        try {
            Map<String, String> maps = mapper.readValue(rentDetails, Map.class);
            Client client = clientService.getOne(Long.parseLong(maps.get("clientId")));
            Room room = roomService.getOne(roomId);
            return rentService.saveRent(client, room, maps);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/rentHistory/{rentId}")
    public String deleteRentHistory(@PathVariable(name = "rentId") long rentId) {

        rentService.deleteById(rentId);
        return "OK";
    }

    @GetMapping(value = "/getMostRecentRent/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rent> getMostRecentRent(@PathVariable(name = "roomId") long roomId) {
        return rentService.getMostRecentRent(roomId);

    }

    @GetMapping(value = "/rentHistory/{rentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rent getRentHistoryById(@PathVariable(name = "rentId") long rentId) {
        return rentService.getOne(rentId);
    }

    @PutMapping(value = "/{rentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Rent saveEditedRent(@PathVariable(name = "rentId") long rentId, @RequestBody String rent) {
        try {
            Map<String, String> maps = mapper.readValue(rent, Map.class);
            Client client = clientService.getOne(Long.parseLong(maps.get("clientId")));
            Room room = roomService.getOne(Long.parseLong(maps.get("rentRoom")));
            return rentService.updateRent(client, room, maps, rentId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
