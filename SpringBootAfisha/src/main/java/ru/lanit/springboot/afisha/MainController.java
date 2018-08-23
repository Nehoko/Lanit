package ru.lanit.springboot.afisha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lanit.springboot.afisha.entities.Afisha;
import ru.lanit.springboot.afisha.repos.AfishaRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private AfishaRepository afishaRepository;

    @GetMapping("/")
    public String showIndex(Map<String, Object> model){
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.put("afisha", performances);
        return "index";
    }
    @GetMapping("/index")
    public String showIndexTwo(Map<String, Object> model){
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.put("afisha", performances);
        return "index";
    }

    @GetMapping("/adminPanel")
    public String showAdminPanel(Map<String, Object> model) {
        Iterable<Afisha> performances = afishaRepository.findAll();
        model.put("afisha", performances);
        return "adminPanel";
    }

    @PostMapping("/")
    public String add(@RequestParam String name, @RequestParam Integer seats,
                      Map<String, Object> model)
    {
        Afisha afisha = new Afisha(name, seats);
        afishaRepository.save(afisha);

        Iterable<Afisha> performances = afishaRepository.findAll();
        model.put("afisha",performances);

        return "index";
    }

    @PostMapping("/search")
    public String find(@RequestParam String search, Map<String, Object> model){
        Iterable<Afisha> afisha;
        if(search != null && !search.isEmpty())
        afisha = afishaRepository.findByName(search);
        else {
            afisha = afishaRepository.findAll();
        }
        model.put("afisha", afisha);

        return "index";
    }
}
