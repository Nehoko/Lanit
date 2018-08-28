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
import ru.lanit.springboot.afisha.repos.AfishaRepository;

@Controller
public class PerformanceController {
    @Autowired
    AfishaRepository afishaRepository;

    @GetMapping("/performance/{performance}")
    public String performanceInfo(@PathVariable Afisha performance, Model model){
        model.addAttribute("performance", performance);
        return "performance/main";
    }


    @GetMapping("/buy/{performance}")
    public String buyTicket(@PathVariable Afisha performance, Model model){
        model.addAttribute("performance",performance);
        return "performance/ticketPurchase";
    }

    @PostMapping("/buy")
    public String buySuccess(
            @RequestParam("place") String place,
            @RequestParam ("performanceId") Afisha performance,
            Model model
    ){
        String message="";
        if(performance.getSeats()==0){
            message="Все места на данный спектакль закончились. Приносим свои извинения.";
        }
        else{
            performance.setSeats(performance.getSeats()-1);

            int seatsOnParter = performance.getSeats_on_parter();
            int seatsOnBalcony = performance.getSeats_on_balcony();
            int seatsOnDressCircle = performance.getSeats_on_dress_circle();

            if(place.equals(performance.getBalcony())){
                if(seatsOnBalcony > 0) {
                    performance.setSeats_on_balcony(seatsOnBalcony - 1);
                    message = "Билет на балкон успешно куплен. Поздравляем!";
                }else message = "Все места на балкон, к сожалению, закончились. Приносим свои извинения.";
            }else if(place.equals(performance.getParter())){
                if(seatsOnParter > 0) {
                    performance.setSeats_on_parter(seatsOnParter - 1);
                    message = "Билет в партер успешно куплен. Поздравляем!";
                }else message = "Все места в партер, к сожалению, закончились. Приносим свои извинения.";
            }else if(place.equals(performance.getDress_circle())){
                if(seatsOnDressCircle > 0) {
                    performance.setSeats_on_dress_circle(seatsOnDressCircle - 1);
                    message = "Билет на бельэтаж успешно купленю Поздравляем!";
                }else message = "Все места на бельэтаж, к сожалению, закончились. Приносим свои извинения.";
            }
        }
        afishaRepository.save(performance);
        model.addAttribute("message",message);
        return "performance/purchaseSucceed";
    }
}