package com.sparrowsanta.real_estate_management_rest.controller;

import com.sparrowsanta.real_estate_management_rest.flat.Flat;
import com.sparrowsanta.real_estate_management_rest.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class Home {

    @Autowired
    private UserService userService;

    //    @GetMapping("")
    @GetMapping("/home")
    public String home(HttpServletResponse servletResponse, HttpServletRequest httpServletRequest) throws IOException {
        Flat flat1 = new Flat(1, "Pierwsze", "Kraków", "Złota Podkowa", "5", "31-322", 2, null, 3, "Moje pierwsze mieszkanie", 34.4, 2010, 305000.00, 2000.0, null, null);

//        flatJpa.save(flat);

//        flatDAO.create(flat);
        servletResponse.sendRedirect(httpServletRequest.getContextPath() + "/swagger-ui.html#/");
//        userService.changeUserPassword("realestate","assass","iiiiiii");
//        userService.changeUserPassword("realestate","password","CodersLab");
//        userService.changeUserPassword("realestate","dswdwdwdw","cccccc");

        return "home";

    }


//    @GetMapping("/hello")
//    public String hello(@RequestParam(required = false) String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
}
