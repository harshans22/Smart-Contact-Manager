package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {


    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("God", "Everytime with you");
        System.out.println("Home Page Handler");
        return "home";

    }
    
}
