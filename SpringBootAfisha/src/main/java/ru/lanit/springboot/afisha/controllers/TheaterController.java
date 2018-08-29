package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.entities.Theater;
import ru.lanit.springboot.afisha.repos.TheaterRepository;

@Controller
public class TheaterController {
    @Autowired
    TheaterRepository theaterRepository;

    @GetMapping("/theater")
    public String showTheaters(
            @RequestParam(required = false, defaultValue = "") String search,
            Model model
    ){
        Iterable<Theater> theaters;

        if(search != null && !search.isEmpty())
            theaters = theaterRepository.findByName(search);
        else {
            theaters = theaterRepository.findAll();
        }
        model.addAttribute("theaters", theaters);
        model.addAttribute("filter", search);

        return "theater/theaterList";
    }

    @GetMapping("/theater/{theater}")
    public String showTheaterAfisha(
            @RequestParam(required = false, defaultValue = "") String search,
            @PathVariable("theater") Theater theater,
            Model model
    ){
        Iterable<Afisha> afisha = theater.getPerformances();
        model.addAttribute("afisha", afisha);

        return "theater/theaterAfisha";
    }

}
