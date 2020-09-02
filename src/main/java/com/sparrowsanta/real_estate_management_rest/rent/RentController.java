package com.sparrowsanta.real_estate_management_rest.rent;

import com.google.gson.Gson;
import com.sparrowsanta.real_estate_management_rest.client.ClientService;
import com.sparrowsanta.real_estate_management_rest.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rents")
public class RentController {
    private RentService rentService;
    private ClientService clientService;
    private RoomService roomService;


    @Autowired
    public RentController(ClientService clientService, RentService rentService, RoomService roomService) {
        this.rentService = rentService;
        this.clientService = clientService;
        this.roomService = roomService;
    }

    @GetMapping(value = "/roomRentHistory/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rent> getRentHistoryByRoomId(@PathVariable(name = "roomId") long roomId) {
        return rentService.getRentHistoryByRoomId(roomId);
    }

    @PostMapping("/{roomId}")
    public String saveRentForRoom(@PathVariable(name = "roomId") long roomId, @RequestBody Rent rentDetails) {
        Rent rent = rentService.save(rentDetails);
//        rent.setClient();
//        rent.setRoom();
        return new Gson().toJson("OK");
    }
}
