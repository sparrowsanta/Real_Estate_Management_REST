package com.sparrowsanta.real_estate_management_rest.flat;

import com.sparrowsanta.real_estate_management_rest.client.ClientForRoomView;
import com.sparrowsanta.real_estate_management_rest.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin - swobodna wymiana elementów między stronami> dopytać?
@RequestMapping(value = "/")
public class FlatController_test {
    //standardJpa package
    @Autowired
    private FlatService flatService;

    @Autowired
    private ClientService clientService;


    @GetMapping("/getAllFlats")
    public List<Flat> getFlats() {
        Flat flat1 = new Flat(1, "Pierwsze", "Kraków", "Złota Podkowa", "5", "31-322", 2, null, 3, "Moje pierwsze mieszkanie", 34.4, 2010, 305000.00, 2000.0, null, null);
        Flat flat = flatService.saveFlat(flat1);

        return flatService.showFlats();

    }


    @GetMapping("/projection")
    @ResponseBody
    public List<ClientForRoomView> test() {

       List<ClientForRoomView> clientForRoomViews = clientService.showClientForRentView();
      return clientForRoomViews;
    }
}
