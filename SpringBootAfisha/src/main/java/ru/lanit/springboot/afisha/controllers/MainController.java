package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.repos.AfishaRepository;
import ru.lanit.springboot.afisha.repos.UserRepository;

@Controller
public class MainController {

    @Autowired
    private AfishaRepository afishaRepository;


    @GetMapping("/")
    public String showIndex(@RequestParam(required = false, defaultValue = "") String search, Model model) {
        Iterable<Afisha> performances;

        if (search != null && !search.isEmpty())
            performances = afishaRepository.findByName(search);
        else {
            performances = afishaRepository.findAll();
        }
        model.addAttribute("afisha", performances);
        model.addAttribute("filter", search);
        return "index";
    }

    @GetMapping("/index")
    public String showIndexTwo() {
        return "redirect: /";
    }

    @GetMapping("/userPanel")
    @PreAuthorize("hasAuthority('USER')")
    public String showUserPanel(Model model) {
        return "userPanel";
    }
}