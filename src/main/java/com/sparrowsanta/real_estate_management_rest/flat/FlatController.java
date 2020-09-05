package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.client.ClientService;
import com.sparrowsanta.real_estate_management_rest.room.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("flats")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/getAllFlats", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flat> getFlats() {
        return flatService.findAll();
    }

    @PostMapping(value = "/addFlat", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long addFlat(@RequestBody Flat flatData) {
        System.out.println(flatData);
        Flat flat = flatService.save(flatData);
        return flat.getId();
    }

    @DeleteMapping(value = "/delete/{id}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public void deleteFlat(@PathVariable(name = "id") long id) {
        flatService.deleteById(id);
    }


    @GetMapping("/flatPicture/{id}")
    @ResponseBody
    public String getFlatPictures(Model model, @PathVariable(name = "id") long id) {
        byte[] pic = flatService.picFlatUrlById(id);
        String image = "";
        if (pic != null && pic.length > 0) {
            image = Base64.getEncoder().encodeToString(pic);
        }
        return image;
    }

    @PostMapping("/flatPicture/{id}")
    public long postRoomPictures(@RequestParam("flatFilePic") MultipartFile flatFilePic, @PathVariable(name = "id") Long id) {

//        String fileName = StringUtils.cleanPath(flatFilePic.getOriginalFilename());

        Flat flat = flatService.getOne(id);
        try {
            flat.setPicUrl(flatFilePic.getBytes());
            flatService.save(flat);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return flat.getId();


    }

    @GetMapping("/getFlatById/{flatId}")
    public Flat getFlatById(@PathVariable(name = "flatId") long flatId) {
        Flat one = flatService.getOne(flatId);
        return one;
    }
//    @GetMapping("/projection")
//    @ResponseBody
//    public List<ClientForRoomView> test() {
//
//        List<ClientForRoomView> clientForRoomViews = clientService.showClientForRentView();
//        return clientForRoomViews;
//    }
}
