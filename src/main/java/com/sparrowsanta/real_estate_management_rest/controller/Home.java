package com.sparrowsanta.real_estate_management_rest.controller;

import com.sparrowsanta.real_estate_management_rest.flat.Flat;
import com.sparrowsanta.real_estate_management_rest.room.Room;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {


    @GetMapping("")
    public String home() {

        Flat flat1 = new Flat(  1, "Pierwsze", "Kraków", "Złota Podkowa", "5", "31-322", 2, null, 3, "Moje pierwsze mieszkanie", 34.4, 2010, 305000.00, 2000.0, null, null);


//        flatJpa.save(flat);

//        flatDAO.create(flat);

        return"home";


        
    }





    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
