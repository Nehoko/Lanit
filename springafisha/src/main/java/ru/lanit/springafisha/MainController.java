package ru.lanit.springafisha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    @RequestMapping("/sign-in")
    public String showSignIn(){
        return "sign-in";
    }
    @RequestMapping("/sign-up")
    public String showSignUp(){
        return "sign-up";
    }
    @RequestMapping("/performance")
    public String showPerformance(){
        return "performance";
    }
    @RequestMapping("/ticket")
    public String showTicket(){
        return "ticket";
    }
    @RequestMapping("/index")
    public String showIndexTwo(){return showIndex();}
}
