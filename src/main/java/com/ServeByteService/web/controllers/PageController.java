package com.ServeByteService.web.controllers;


import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

//    @Value("${phoneNumber}")
    private String phoneNumber;


//    This will create a dashboard.html in the "Resources Folder"
    @GetMapping("/")
    public ModelAndView showUserDashboard(){

        ModelAndView dashboard = new ModelAndView("dashboard");
        dashboard.addObject("phoneNumber", phoneNumber);
                return dashboard;
            }
}
