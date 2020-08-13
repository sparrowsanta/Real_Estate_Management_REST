package com.sparrowsanta.real_estate_management_rest.controller;

import com.sparrowsanta.real_estate_management_rest.entity.Flat;
import com.sparrowsanta.real_estate_management_rest.standardJpa.test.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // or @Controller
@CrossOrigin
@RequestMapping(value = "/")
public class TestController {
    //standardJpa package
    private final FlatService flatService;
    @Autowired
    public TestController(FlatService flatService) {
        this.flatService = flatService;
    }


    @GetMapping("/getAllFlats")
    public List<Flat> getFlats() {
        Flat flat1 = new Flat( 1, "Pierwsze", "Kraków", "Złota Podkowa", "5", "31-322", 2, null, 3, "Moje pierwsze mieszkanie", 34.4, 2010, 305000.00, 2000.0, null);
        flatService.save(flat1);
        return flatService.findAll();
    }
}
