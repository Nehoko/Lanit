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
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showAdminPanel(Model model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.addAttribute("afisha", performances);
        return "adminPanel";
    }

    @GetMapping("/user")
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
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
    public String getAfishaList(Model model){
        model.addAttribute("afisha", afishaRepository.findAll());
        return "/afishaList";
    }
}
