package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.entities.Theater;
import ru.lanit.springboot.afisha.entities.User;
import ru.lanit.springboot.afisha.enums.Role;
import ru.lanit.springboot.afisha.repos.AfishaRepository;
import ru.lanit.springboot.afisha.repos.TheaterRepository;
import ru.lanit.springboot.afisha.repos.UserRepository;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AfishaRepository afishaRepository;

    @Autowired
    TheaterRepository theaterRepository;

    //Панель управления Администрации
    @GetMapping("/adminPanel")
    public String showAdminPanel(Model model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.addAttribute("afisha", performances);
        return "admin/adminPanel";
    }
    //Список пользователей
    @GetMapping("/user")
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "admin/userList";
    }
    //Один пользователь из списка
    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "admin/userEdit";
    }
    //Изменение информации о пользователе
    @PostMapping("/user")
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user)
    {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
        return "redirect:/user";
    }
    //Афиша определённого театра из списка театров с возможностью редактирования
    @GetMapping("/theater/{theater}/afisha/edit")
    public String theaterAfishaEditList(
            @PathVariable Theater theater,
            @RequestParam(required = false, defaultValue = "") String search,
            Model model){
        Iterable<Afisha> performances;
            if(search != null && !search.isEmpty())
                performances = afishaRepository.findByTheaterAndName(theater, search);
            else
                performances = afishaRepository.findByTheater(theater);

        model.addAttribute("afisha", performances);
        model.addAttribute("filter", search);
        model.addAttribute("nullAfisha", new Afisha());
        model.addAttribute("theater", theater);
        return "admin/afisha";
    }
    //Страница редактирования спектакля
    @GetMapping("/afisha/{performance}/edit")
    public String performanceEditForm(
            @PathVariable Afisha performance,
            Model model){
        model.addAttribute("performance", performance);
        return "admin/afishaEdit";
    }
    //Редактирование афиши определенного театра
    @PostMapping("/theater/{theater}/afisha/edit")
    public String editAfisha(
            @PathVariable Theater theater,
            @RequestParam String name,
            @RequestParam Integer seats,
            @RequestParam ("seats_on_parter") Integer parterSeats,
            @RequestParam ("price_parter") Integer parterPrice,
            @RequestParam ("seats_on_balcony") Integer balconySeats,
            @RequestParam ("price_balcony") Integer balconyPrice,
            @RequestParam ("seats_on_dress_circle") Integer dressCircleSeats,
            @RequestParam ("price_dress_circle") Integer dressCirclePrice,
            @RequestParam("performanceId") Afisha performance,
            Model model
    ){
            performance.setName(name);
            performance.setSeats(seats);

            performance.setSeats_on_balcony(balconySeats);
            performance.setPrice_balcony(balconyPrice);

            performance.setSeats_on_parter(parterSeats);
            performance.setPrice_parter(parterPrice);

            performance.setSeats_on_dress_circle(dressCircleSeats);
            performance.setPrice_dress_circle(dressCirclePrice);

            afishaRepository.save(performance);

            model.addAttribute("theater", theater);
            return "redirect:/theater/{theater}/afisha/edit";
    }

    //Добавление спектакля в афишу
    @PostMapping("/theater/{theater}/afisha/add")
    public String addPerformance(
            @PathVariable Theater theater,
            @RequestParam String name,
            @RequestParam Integer seats,
            @RequestParam ("seats_on_parter") Integer parterSeats,
            @RequestParam ("price_parter") Integer parterPrice,
            @RequestParam ("seats_on_balcony") Integer balconySeats,
            @RequestParam ("price_balcony") Integer balconyPrice,
            @RequestParam ("seats_on_dress_circle") Integer dressCircleSeats,
            @RequestParam ("price_dress_circle") Integer dressCirclePrice,
            @RequestParam String description,
            Model model) {
        Afisha performance = new Afisha(name, seats);
        performance.setTheater(theater);

        performance.setSeats_on_balcony(balconySeats);
        performance.setPrice_balcony(balconyPrice);

        performance.setSeats_on_parter(parterSeats);
        performance.setPrice_parter(parterPrice);

        performance.setSeats_on_dress_circle(dressCircleSeats);
        performance.setPrice_dress_circle(dressCirclePrice);

        performance.setDescription(description);
        afishaRepository.save(performance);

        Iterable<Afisha> performances = afishaRepository.findByTheater(theater);
        model.addAttribute("afisha", performances);
        model.addAttribute("theater", theater);

        return "redirect:/theater/{theater}/afisha/edit";
    }
    //Удаление спектакля из афиши театра
    @GetMapping("/theater/{theater}/afisha/delete/{performance}")
    public String deletePerformance(
            @PathVariable Theater theater,
            @PathVariable Afisha performance){
        afishaRepository.delete(performance);
        return "redirect:theater/{theater}/afisha";
    }
    //Список театров с возможностью редактирования
    @GetMapping("/theater/edit")
    public String showTheaters(@RequestParam(required = false, defaultValue = "") String search, Model model){
        Iterable<Theater> theaters;

        if (search !=null && !search.isEmpty())
            theaters = theaterRepository.findByName(search);
        else {
            theaters = theaterRepository.findAll();
        }
        model.addAttribute("nullTheater", new Theater());
        model.addAttribute("theaters", theaters);
        model.addAttribute("filter", search);
        return "admin/theater";
    }
    //Добавление нового театра в список театров
    @PostMapping("/theater/edit")
    public String addTheater(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam Integer mailbox,
            @RequestParam(required = false, defaultValue = "") String description,
            Model model
    ){
        Theater theater = new Theater(name, address, mailbox);
        theater.setDescription(description);
        theaterRepository.save(theater);

        Iterable<Theater> theaters = theaterRepository.findAll();
        model.addAttribute("theaters", theaters);

        return "redirect:/theater/edit";
    }
    //Удаление театра из списка театров
    @GetMapping("/theater/delete/{theater}")
    public String deleteTheater(@PathVariable Theater theater){
        theaterRepository.delete(theater);

        return "redirect:/theater/edit";
    }
    //Просмотр конкретного театра с возможностью редактирования
    @GetMapping("/theater/{theater}/edit")
    public String editTheaterForm(@PathVariable Theater theater, Model model){
        model.addAttribute("theater",theater);

        return "admin/theaterEdit";
    }
}