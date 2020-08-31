package com.sparrowsanta.real_estate_management_rest.room;

import com.google.gson.Gson;
import com.sparrowsanta.real_estate_management_rest.flat.Flat;
import com.sparrowsanta.real_estate_management_rest.flat.FlatService;
import com.sparrowsanta.real_estate_management_rest.utils.FlatConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {

    private final RoomService roomService;
    private final FlatService flatService;
    private final FlatConverter flatConverter;

    @Autowired
    public RoomController(RoomService roomService, FlatService flatService, FlatConverter flatConverter) {
        this.roomService = roomService;
        this.flatService = flatService;
        this.flatConverter = flatConverter;

    }

    @GetMapping("/findAllByFlatId/{flatId}")
    public List<Room> findAllByFlatId(@PathVariable(name = "flatId") Long flatId) {
        return roomService.findAllByFlatId(flatId);

    }


    @PostMapping("/addRoomsForFlat/{flatId}")
    public String saveRoomsForFlat(@PathVariable(name = "flatId") Long flatId, @RequestBody Room[] data) {
        for (int i = 0; i < data.length; i++) {
            Room room = data[i];
            room.setFlat(flatService.getOne(flatId));
            roomService.save(room);
        }
        return "OK";
    }
}









/*        String[] tableOfRooms = data.split("},\\{");
        String[] tableOfRoomsReplaced = Arrays.stream(tableOfRooms)
                .map(s -> s.replaceAll("(\\[)|(\\])|(\\{)|(\\})", ""))
                .map(s -> s.replaceAll("", ""))
                .toArray(size -> new String[size]);
        Gson gson = new Gson();

        for (int i = 0; i < tableOfRoomsReplaced.length; i++) {
            roomService.save(gson.fromJson("{" + tableOfRoomsReplaced[i] + "}", Room.class));

        }
        Room room1 = gson.fromJson("{" + tableOfRoomsReplaced[0] + "}", Room.class);*/

