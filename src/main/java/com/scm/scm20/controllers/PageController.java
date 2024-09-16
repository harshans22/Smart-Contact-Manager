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
    

    // about
    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("name", "About Page loading");
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String services(Model model){
        model.addAttribute("name", "Services Page loading");
        return "services";
    }

    //contact
    @RequestMapping("/contact")
    public String contact(Model model){
        model.addAttribute("name", "contact Page loading");
        return "contact";
    }

    //login
    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("name", "contact Page loading");
        return "login";
    }


    //signUp
    @RequestMapping("/register")
    public String signUp(Model model){
        model.addAttribute("name", "contact Page loading");
        return "register";
    }
}
