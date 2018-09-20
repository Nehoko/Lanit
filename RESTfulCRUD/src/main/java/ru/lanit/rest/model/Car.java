package ru.lanit.rest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="car")
public class Car implements Serializable {

    @Id
    @NotNull
    private Long id;

    @Column(name = "model")
    @NotNull
    private String model;

    @Column(name = "horse_power")
    @NotNull
    private Integer horsepower;



    @NotNull
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Person owner;

    @NotNull
    @Column(name = "ownerid")
    private Long ownerId;

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Car(){}

    public Car(Long id, String model, Integer horsepower, Long ownerId){
        this.id = id;
        this.model = model;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model.matches("^[a-zA-Z0-9]+-[a-zA-Z0-9]+$"))
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
