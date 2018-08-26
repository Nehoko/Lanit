package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.repos.AfishaRepository;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private AfishaRepository afishaRepository;

    @GetMapping("/")
    public String showIndex(@RequestParam(required = false, defaultValue = "Введите название спектакля") String search, Map<String, Object> model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.put("afisha", performances);

        if (search != null && !search.isEmpty())
            performances = afishaRepository.findByName(search);
        else {
            performances = afishaRepository.findAll();
        }
        model.put("afisha", performances);
        model.put("search", search);
        return "index";
    }

    @GetMapping("/index")
    public String showIndexTwo(Map<String, Object> model) {
        return "redirect: /";
    }

    @GetMapping("/adminPanel")
    public String showAdminPanel(Map<String, Object> model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.put("afisha", performances);
        return "adminPanel";
    }

    @GetMapping("/userPanel")
    public String showUserPanel(Map<String, Object> model) {
        return "userPanel";
    }

    @PostMapping("/")
    public String add(
            @RequestParam String name,
            @RequestParam Integer seats,
            Map<String, Object> model) {
        Afisha afisha = new Afisha(name, seats);
        afishaRepository.save(afisha);

        Iterable<Afisha> performances = afishaRepository.findAll();
        model.put("afisha", performances);

        return "index";
    }
}