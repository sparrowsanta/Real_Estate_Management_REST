package com.sparrowsanta.real_estate_management_rest.furniture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("furnitures")
public class FurnitureController {
    @Autowired
    private FurnitureService furnitureService;

/*    @Autowired
    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }*/

    @DeleteMapping(value = "/{furnitureId}", produces = "text/plain;charset=UTF-8")
    public String deleteFurniture(@PathVariable(name = "furnitureId") long furnitureId) {
        furnitureService.deleteById(furnitureId);
        return "OK";

    }

    @GetMapping(value = "/furniture/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Furniture> showAllFurniture(Model model, @PathVariable(name = "roomId") long roomId) {
        List<Furniture> allByRoomId = furnitureService.findAllByRoomId(roomId);
        return allByRoomId;

    }

    @PostMapping(value = "/update/{roomId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateFurnitureForRoom(@PathVariable(name = "roomId") long roomId, @RequestBody Furniture[] data) {
        furnitureService.updateFurnitures(data, roomId);
        return "OK";
    }

    @GetMapping(value = "/furnitureById/{furnitureId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Furniture getFurnitureById(@PathVariable(name = "furnitureId") long furnitureId) {
        return furnitureService.getOne(furnitureId);
    }


}
