package ru.lanit.springboot.afisha.entities;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private int mailbox;
    private String description;

    public Theater(){
    }

    public Theater(String name, String address, int mailbox){
        setName(name);
        setAddress(address);
        setMailbox(mailbox);
    }

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Afisha> performances;

    public Set<Afisha> getPerformances() {
        return performances;
    }

    public void setPerformances(Set<Afisha> performances) {
        this.performances = performances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public int getMailbox() {
        return mailbox;
    }

    public void setMailbox(int mailbox) {
        this.mailbox = mailbox;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
