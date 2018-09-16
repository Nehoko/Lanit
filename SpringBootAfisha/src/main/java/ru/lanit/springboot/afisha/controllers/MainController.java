package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.entities.Theater;
import ru.lanit.springboot.afisha.repos.AfishaRepository;
import ru.lanit.springboot.afisha.repos.TheaterRepository;
import ru.lanit.springboot.afisha.repos.UserRepository;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AfishaRepository afishaRepository;

    @Autowired
    private TheaterRepository theaterRepository;


    @GetMapping("/")
    public String showIndex(@RequestParam(required = false, defaultValue = "") String search, Model model) {
        Iterable<Afisha> performances;
        List<Theater> theaters = theaterRepository.findByName("Наш");

        Theater nash = theaters.get(0);

        if (search != null && !search.isEmpty())
            performances = afishaRepository.findByTheaterAndName(nash, search);
        else {
            performances = afishaRepository.findByTheater(nash);
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