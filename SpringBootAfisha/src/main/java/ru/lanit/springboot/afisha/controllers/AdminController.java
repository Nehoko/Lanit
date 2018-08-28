package ru.lanit.springboot.afisha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.entities.User;
import ru.lanit.springboot.afisha.enums.Role;
import ru.lanit.springboot.afisha.repos.AfishaRepository;
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

    @GetMapping("/adminPanel")
    public String showAdminPanel(Model model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.addAttribute("afisha", performances);
        return "admin/adminPanel";
    }

    @GetMapping("/user")
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "admin/userList";
    }

    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "admin/userEdit";
    }

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

    @GetMapping("/afisha")
    public String afishaList(
            @RequestParam(required = false, defaultValue = "") String search,
            Model model){
        Iterable<Afisha> performances;

        if (search != null && !search.isEmpty())
            performances = afishaRepository.findByName(search);
        else {
            performances = afishaRepository.findAll();
        }
        model.addAttribute("afisha", performances);
        model.addAttribute("filter", search);
        model.addAttribute("nullAfisha", new Afisha());
        return "admin/afisha";
    }
    @GetMapping("/afisha/{performance}")
    public String afishaEditForm(@PathVariable Afisha performance, Model model){
        model.addAttribute("performance", performance);
        return "admin/afishaEdit";
    }

    @PostMapping("/afisha")
    public String editAfisha(
            @RequestParam String name,
            @RequestParam Integer seats,
            @RequestParam ("seats_on_parter") Integer parterSeats,
            @RequestParam ("price_parter") Integer parterPrice,
            @RequestParam ("seats_on_balcony") Integer balconySeats,
            @RequestParam ("price_balcony") Integer balconyPrice,
            @RequestParam ("seats_on_dress_circle") Integer dressCircleSeats,
            @RequestParam ("price_dress_circle") Integer dressCirclePrice,
            @RequestParam("performanceId") Afisha performance
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
            return "redirect:/afisha";
    }


    @PostMapping("/afisha/edit")
    public String addPerformance(
            @RequestParam String name,
            @RequestParam Integer seats,
            Model model) {
        Afisha afisha = new Afisha(name, seats);
        afishaRepository.save(afisha);

        Iterable<Afisha> performances = afishaRepository.findAll();
        model.addAttribute("afisha", performances);

        return "redirect:/afisha";
    }

    @GetMapping("/afisha/delete/{performance}")
    public String deletePerformance(
            @PathVariable Afisha performance){
        afishaRepository.delete(performance);
        return "redirect:/afisha";
    }
}