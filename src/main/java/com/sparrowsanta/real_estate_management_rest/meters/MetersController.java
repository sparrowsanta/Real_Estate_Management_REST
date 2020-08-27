package com.sparrowsanta.real_estate_management_rest.meters;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meters")
@RequiredArgsConstructor
public class MetersController {
    //standardJpa package
    @Autowired
    private MetersService metersService;


    @GetMapping("/getAllFlats")
    public List<Meters> getFlats() {

        return null;
    }

    @PostMapping(value = "/add", produces = "text/plain;charset=UTF-8")
    public String addMeter(@RequestBody Meters meter) {
        metersService.save(meter);
        return "Ok";


    }


}
