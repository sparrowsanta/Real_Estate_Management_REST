package com.sparrowsanta.real_estate_management_rest.flat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin - swobodna wymiana elementów między stronami> dopytać?
@RequestMapping(value = "/")
public class FlatController_test {
    //standardJpa package
    @Autowired
    private FlatService flatService;




    @GetMapping("/getAllFlats")
    public List<Flat> getFlats() {
        Flat flat1 = new Flat(1, "Pierwsze", "Kraków", "Złota Podkowa", "5", "31-322", 2, null, 3, "Moje pierwsze mieszkanie", 34.4, 2010, 305000.00, 2000.0, null, null);
        Flat flat = flatService.save(flat1);
        flatService.updateById(flat, 2L);
        return flatService.findAll();

    }


    @GetMapping("/uploadFlat")
    public void uploadFlat(){

/*        try {
            user.setFile(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
