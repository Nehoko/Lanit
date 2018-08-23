package ru.lanit.springafisha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.lanit.springafisha.entities.User;

@Controller
@RequestMapping("/")
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
    @RequestMapping("/adminPanel")
    public String showAdmin(){ return "adminPanel"; }
    @RequestMapping("/userPanel")
    public String showPanel(){ return "userPanel"; }


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public @ResponseBody String addNewUser(@RequestParam String login, @RequestParam String password){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return "saved";
    }

    @GetMapping("/allUsers")
    public @ResponseBody Iterable<User> showAllUsers(){
        //This return JSON or XML with the users
        return userRepository.findAll();
    }
}
