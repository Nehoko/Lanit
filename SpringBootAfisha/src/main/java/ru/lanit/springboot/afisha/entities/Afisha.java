package ru.lanit.springboot.afisha.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Afisha{

    public Afisha(){}

    public Afisha(String name, Integer seats) {
        this.name = name;
        this.seats = seats;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer seats;

    private String date;

    private Integer seats_on_balcony;

    private Integer seats_on_parter;

    private Integer seats_on_dress_circle;

    private Integer price_balcony;

    private Integer price_parter;

    private Integer price_dress_circle;

    private SimpleDateFormat dateFormat;

    private String description;

    private final String balcony = "balcony";

    private final String parter = "parter";

    private final String dress_circle = "dress_circle";

    public String getBalcony() {
        return balcony;
    }

    public String getParter() {
        return parter;
    }

    public String getDress_circle() {
        return dress_circle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSeats_on_balcony() {
        return seats_on_balcony;
    }

    public void setSeats_on_balcony(Integer seats_on_balcony) {
        this.seats_on_balcony = seats_on_balcony;
    }

    public Integer getSeats_on_parter() {
        return seats_on_parter;
    }

    public void setSeats_on_parter(Integer seats_on_parter) {
        this.seats_on_parter = seats_on_parter;
    }

    public Integer getSeats_on_dress_circle() {
        return seats_on_dress_circle;
    }

    public void setSeats_on_dress_circle(Integer seats_on_dress_circle) {
        this.seats_on_dress_circle = seats_on_dress_circle;
    }

    public Integer getPrice_balcony() {
        return price_balcony;
    }

    public void setPrice_balcony(Integer price_balcony) {
        this.price_balcony = price_balcony;
    }

    public Integer getPrice_parter() {
        return price_parter;
    }

    public void setPrice_parter(Integer price_parter) {
        this.price_parter = price_parter;
    }

    public Integer getPrice_dress_circle() {
        return price_dress_circle;
    }

    public void setPrice_dress_circle(Integer price_dress_circle) {
        this.price_dress_circle = price_dress_circle;
    }
}
