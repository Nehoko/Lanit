package ru.lanit.rest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model")
    @NotNull
    private String model;

    @Column(name = "horse_power")
    @NotNull
    private Integer horsepower;

    @NotNull
    @JoinColumn(name = "owner_id")
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Person ownerId;

    public Car(){}

    public Car(Long id, String model, Integer horsepower){
        this.horsepower = horsepower;
        this.id = id;
        this.model = model;

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
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Person getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Person ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", horsepower=" + horsepower +
                ", ownerId=" + ownerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(model, car.model) &&
                Objects.equals(horsepower, car.horsepower) &&
                Objects.equals(ownerId, car.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, horsepower, ownerId);
    }
}
