package com.scm.scm20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.helper.Message;
import com.scm.scm20.helper.MessageType;
import com.scm.scm20.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
        UserForm userForm=new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing register
    @RequestMapping(value="/do-register",method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session){
        
        // User user=User.builder().name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profileLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYkpAMeQ7efqBOQKrfmaR28jcKnHZgK5cQ9w&s")
        // .build();
        


        
        //validate
        if(rBindingResult.hasErrors()){
            return "register";
        }

        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfileLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYkpAMeQ7efqBOQKrfmaR28jcKnHZgK5cQ9w&s");


        Message message=Message.builder().content("Registration Successfull").type(MessageType.green).build();
        //add the message
        session.setAttribute("message", message);

        userService.saveUser(user);
        return "redirect:/register";
    }
}
