package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lanit.springboot.afisha.entities.User;
import ru.lanit.springboot.afisha.service.UserService;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/sign-up")
    public String registration(){
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String addUser(User user, Model model){
        if (!userService.addUser(user)){
            model.addAttribute("message", "User already exists!");
            return "sign-up";
        }
        return "redirect:/login";
    }
}
