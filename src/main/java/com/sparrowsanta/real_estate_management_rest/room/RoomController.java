package com.sparrowsanta.real_estate_management_rest.room;

import com.sparrowsanta.real_estate_management_rest.flat.FlatService;
import com.sparrowsanta.real_estate_management_rest.utils.FlatConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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

    @GetMapping("/roomsForFlat/{flatId}")
    public List<Room> getAllRoomsForFlat(@PathVariable(name = "flatId") long flatId) {
        List<Room> allByFlatId = roomService.findAllByFlatId(flatId);
        return allByFlatId;
    }

    @PostMapping("/roomPicture/{id}")
    public long postRoomPictures(@RequestParam("roomFilePic") MultipartFile roomFilePic, @PathVariable(name = "id") long id) {
        Room room = roomService.getOne(id);
        try {
            room.setPicUrl(roomFilePic.getBytes());
            roomService.save(room);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return room.getFlat().getId();
    }

    @GetMapping("/roomPicture/{id}")
    public String getRoomPictures(@PathVariable(name = "id") long id) {
        roomService.picUrlById(id);

        byte[] pic = roomService.picUrlById(id);
        String image = "";
        if (pic != null && pic.length > 0) {
            image = Base64.getEncoder().encodeToString(pic);
        }
        return image;
    }

    @DeleteMapping(value = "/delete/{roomId}", produces = "text/plain;charset=UTF-8")
    public String deleteRoom(@PathVariable(name = "roomId") long roomId) {
        roomService.deleteById(roomId);
        return "OK";

    }

    @GetMapping(value = "/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getRoomById(@PathVariable(name = "roomId") long roomId) {
        return roomService.getOne(roomId);
    }

    @PutMapping(value = "/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public long updateRoomById(@RequestBody Room room, @PathVariable(name = "roomId") long roomId) {
        roomService.updateRoomDetails(room.getDescription(), room.getRoomSquareMeters(), room.getExpectedRentPrice(), room.getRoomType().value, roomId);
        return roomService.getFlatByRoomId(roomId);
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

