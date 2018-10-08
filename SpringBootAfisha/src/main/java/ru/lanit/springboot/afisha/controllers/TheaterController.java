package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.entities.Theater;
import ru.lanit.springboot.afisha.repos.AfishaRepository;
import ru.lanit.springboot.afisha.repos.TheaterRepository;
import ru.lanit.springboot.afisha.service.AfishaService;

@Controller
public class TheaterController {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    AfishaRepository afishaRepository;

    @Autowired
    AfishaService afishaService;


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

    @GetMapping("/theater/{theater}/afisha")
    public String showTheaterAfisha(
            @RequestParam(required = false, defaultValue = "") String search,
            @PathVariable Theater theater,
            Model model
    ){
        Iterable<Afisha> afisha;



        if(search!=null && !search.isEmpty())
               afisha = afishaService.getAfishaByTheaterAndName(theater, search);
        else{
            afisha = afishaService.getAfishaByTheater(theater);
        }

        model.addAttribute("afisha", afisha);
        model.addAttribute("theater",theater);
        model.addAttribute("filter", search);

        return "theater/theaterAfisha";
    }

    @GetMapping("/theater/{theater}")
    public String showTheater(
            @PathVariable Theater theater, Model model){
        model.addAttribute("theater", theater);

        return "/theater/main";
    }
}
