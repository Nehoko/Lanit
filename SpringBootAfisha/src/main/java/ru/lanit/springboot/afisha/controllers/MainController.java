package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.repos.AfishaRepository;
import ru.lanit.springboot.afisha.repos.UserRepository;

@Controller
public class MainController {

    @Autowired
    private AfishaRepository afishaRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showIndex(@RequestParam(required = false, defaultValue = "") String search, Model model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.addAttribute("afisha", performances);

        //model.addAttribute("users",userRepository.findAll());

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
    public String showIndexTwo(Model model) {
        return "redirect: /";
    }

    @GetMapping("/adminPanel")
    public String showAdminPanel(Model model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.addAttribute("afisha", performances);
        return "adminPanel";
    }

    @GetMapping("/userPanel")
    public String showUserPanel(Model model) {
        return "userPanel";
    }

    @PostMapping("/")
    public String add(
            @RequestParam String name,
            @RequestParam Integer seats,
            Model model) {
        Afisha afisha = new Afisha(name, seats);
        afishaRepository.save(afisha);

        Iterable<Afisha> performances = afishaRepository.findAll();
        model.addAttribute("afisha", performances);

        return "index";
    }
}