package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lanit.springboot.afisha.entities.User;
import ru.lanit.springboot.afisha.enums.Role;
import ru.lanit.springboot.afisha.repos.UserRepository;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/sign-up")
    public String registration(){
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String addUser(User user, Model model){
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null){
            model.addAttribute("message", "User already exists!");
            return "sign-up";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}
