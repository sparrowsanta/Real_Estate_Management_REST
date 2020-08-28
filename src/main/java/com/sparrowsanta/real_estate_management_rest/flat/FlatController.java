package com.sparrowsanta.real_estate_management_rest.flat;

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


    @GetMapping("/allFlats")
    public List<Flat> getFlats() {
        return flatService.findAll();
    }

    @PostMapping(value = "/addFlat", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Flat addFlat(@RequestParam(value = "file") MultipartFile file, MultipartHttpServletRequest mrequest) {
        System.out.println(mrequest);

        Flat flat = new Flat();
        return flatService.save(flat);
    }


//    @GetMapping("/projection")
//    @ResponseBody
//    public List<ClientForRoomView> test() {
//
//        List<ClientForRoomView> clientForRoomViews = clientService.showClientForRentView();
//        return clientForRoomViews;
//    }
}
